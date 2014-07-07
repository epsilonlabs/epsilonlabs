package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.TextRegion;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.newExpression_return;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.ast2etl.Ast2EtlContext;
import org.eclipse.epsilon.etl.ast2etl.EtlElementCreatorFactory;
import org.eclipse.epsilon.etl.dtx.editor.EtlxEditor;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.RuleDependency;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.visitor.resolution.type.impl.EtlTypeResolver;
import org.eclipse.epsilon.etl.visitor.resolution.variable.impl.EtlVariableResolver;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalTreeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.VerticalLayoutAlgorithm;

public class TransformationDependencyGraph extends ViewPart {

	  public static final String ID = "org.eclipse.epsilon.etl.dtx.transformation.dependency";
	  private Graph graph;
	  private int layout = 1;
	  
	  private Composite parent;
	  protected HashMap<GraphItem, EolElement> graphMap = new HashMap<GraphItem, EolElement>(); 

	  public TransformationDependencyGraph() {
		  super();
		// TODO Auto-generated constructor stub
	  }

	  public EtlxEditor getEditor()
	  {
		  IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			IEditorPart editor = page.getActiveEditor();
			if (editor instanceof EtlxEditor) {
				return (EtlxEditor) editor;
			}
			else {
				return null;
			}
	  }
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		EtlxEditor leEditor = getEditor();
		if (leEditor.getEolLibraryModule() != null) {
			graph = getDependencyGraph((EtlProgram) leEditor.getEolLibraryModule(), parent);
		}
		
		
//		graph = new Graph(parent, SWT.NONE);
//		
//		
//		
//	    // now a few nodes
//	    GraphNode node1 = new GraphNode(graph, SWT.NONE, "Jim");
//	    GraphNode node2 = new GraphNode(graph, SWT.NONE, "Jack");
//	    GraphNode node3 = new GraphNode(graph, SWT.NONE, "Joe");
//	    GraphNode node4 = new GraphNode(graph, SWT.NONE, "Bill");
//	    // Lets have a directed connection
//	    new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1,
//	        node2);
//	    // Lets have a dotted graph connection
//	    new GraphConnection(graph, ZestStyles.CONNECTIONS_DOT, node2, node3);
//	    // Standard connection
//	    new GraphConnection(graph, SWT.NONE, node3, node1);
//	    // Change line color and line width
//	    GraphConnection graphConnection = new GraphConnection(graph, SWT.NONE,
//	        node1, node4);
//	    graphConnection.changeLineColor(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
//	    // Also set a text
//	    graphConnection.setText("This is a text");
//	    graphConnection.setHighlightColor(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
//	    graphConnection.setLineWidth(3);
//
//	    graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
//	    // Selection listener on graphConnect or GraphNode is not supported
//	    // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=236528
//	    graph.addSelectionListener(new SelectionAdapter() {
//	      @Override
//	      public void widgetSelected(SelectionEvent e) {
//	        System.out.println(e);
//	      }
//
//	    });

		contributeToActionBars();
	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		//fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		//manager.add(action1);
		//manager.add(action2);
		manager.add(new RefreshTransformationDependencyViewAction(this));
	}

	public void setLayoutManager() {
	    switch (layout) {
	    case 1:
	      graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
	      layout++;
	      break;
	    case 2:
	      graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
	      layout = 1;
	      break;

	    }

	  }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public Graph getDependencyGraph(EtlProgram etlProgram, Composite parent)
	{
		Graph g = new Graph(parent, SWT.NONE);
		HashMap<TransformationRule, GraphNode> map = new HashMap<TransformationRule, GraphNode>();
		
		for(TransformationRule rule: etlProgram.getTransformationRules())
		{
			GraphNode node = new GraphNode(g, SWT.NONE, rule.getName().getName());
			graphMap.put(node, rule);
			map.put(rule, node);
			
			for(RuleDependency dependency: rule.getResolvedRuleDependencies())
			{
				TransformationRule dependingRule = dependency.getDependingRule();
				if (map.containsKey(dependingRule)) {
					
					GraphNode leNode = map.get(dependingRule);
					
					GraphConnection connection = new GraphConnection(g, ZestStyles.CONNECTIONS_DIRECTED, node,
					        leNode);
					graphMap.put(connection, dependency.getSourceElement());
					connection.setText("depends on");
					if (dependingRule.equals(rule)) {
						connection.setCurveDepth(30);
					}
				}
				else {
					GraphNode leNode = new GraphNode(g, SWT.NONE, rule.getName().getName());
					map.put(dependingRule, leNode);
					GraphConnection connection = new GraphConnection(g, ZestStyles.CONNECTIONS_DIRECTED, node,
					        leNode);
					connection.setText("depends on");
				}
			}
		}
		g.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				EolElement selectedElement = graphMap.get(e.item);
				if (selectedElement != null) {
					EtlxEditor editor = getEditor();
					try {
						IDocument doc = editor.getDocumentProvider().getDocument(editor.getEditorInput());
						TextRegion region = selectedElement.getRegion();
						
						int startOffset = doc.getLineOffset(region.getStart().getLine()-1) + region.getStart().getColumn();
						int endOffset = doc.getLineOffset(region.getEnd().getLine()-1) + region.getEnd().getColumn();
						
						FileEditorInput fileInputEditor = (FileEditorInput) editor.getEditorInput();
						IFile file = fileInputEditor.getFile();

						EclipseUtil.openEditorAt(file, region.getStart().getLine(), 
								region.getStart().getColumn(), endOffset - startOffset, false);

					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
			}
				
		});
		g.setLayoutAlgorithm(new HorizontalTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		//g.setLayoutAlgorithm(new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		//g.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		return g;
	}
	
	public void refresh(){
		
		if (graph != null) {
			graph.dispose();	
		}
		
		
		EtlxEditor leEditor = getEditor();
		if (leEditor.getEolLibraryModule() != null) {
			graph = getDependencyGraph((EtlProgram) leEditor.getEolLibraryModule(), parent);
		}
		
		graph.applyLayout();
		//parent.pack();
		parent.layout();
		
		
	}
	
	

}
