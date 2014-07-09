package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import java.awt.SystemColor;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.ColorConstants.SystemColorFactory;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.TextRegion;
import org.eclipse.epsilon.etl.dtx.editor.EtlxEditor;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.RuleDependency;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.HorizontalTreeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

public class TransformationDependencyViewer extends Composite{

	private Graph graph;
	private int layout = 1;

	protected HashMap<GraphItem, EolElement> graphMap = new HashMap<GraphItem, EolElement>(); 
	private Composite parent;


	public TransformationDependencyViewer(Composite parent, int style)
	{
		super(parent, style);
		this.parent = parent;
		this.setLayout(new FillLayout());
//		this.setBackground(new Color(Display.getCurrent(), new RGB(63, 127, 95)));
		EtlxEditor leEditor = getEditor();
		if (leEditor.getEolLibraryModule() != null) {
			graph = getDependencyGraph((EtlProgram) leEditor.getEolLibraryModule(), this);
		}
	}
	
	public Graph getDependencyGraph(EtlProgram etlProgram, Composite parent)
	{
		Graph g = new Graph(parent, SWT.NONE);
		System.err.println("Bounds: " + getBounds());
//		g.setBackground(new Color(Display.getCurrent(), new RGB(127, 0, 85)));
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
	  
	public void refresh(){
		if (graph != null) {
			graph.dispose();
		}
		this.setLayout(new FillLayout());
		EtlxEditor leEditor = getEditor();
		if (leEditor.getEolLibraryModule() != null) {
			graph = getDependencyGraph((EtlProgram) leEditor.getEolLibraryModule(), this);
		}
		graph.applyLayout();
		this.layout();
		//parent.layout();
	}

//	public void setLayoutManager() {
//	    switch (layout) {
//	    case 1:
//	      graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
//	      layout++;
//	      break;
//	    case 2:
//	      graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
//	      layout = 1;
//	      break;
//
//	    }
//
//	  }

}
