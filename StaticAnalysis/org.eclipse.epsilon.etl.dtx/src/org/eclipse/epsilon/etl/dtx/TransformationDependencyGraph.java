package org.eclipse.epsilon.etl.dtx;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.ast2etl.Ast2EtlContext;
import org.eclipse.epsilon.etl.ast2etl.EtlElementCreatorFactory;
import org.eclipse.epsilon.etl.dtx.editor.EtlxEditor;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.visitor.resolution.type.impl.EtlTypeResolver;
import org.eclipse.epsilon.etl.visitor.resolution.variable.impl.EtlVariableResolver;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

public class TransformationDependencyGraph extends ViewPart {

	  public static final String ID = "org.eclipse.epsilon.etl.dtx.transformation.dependency";
	  private Graph graph;
	  private int layout = 1;

	public TransformationDependencyGraph() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		IEditorPart editor = page.getActiveEditor();
		if (editor instanceof EtlxEditor) {
			EtlxEditor leEditor = (EtlxEditor) editor;
			if (leEditor.getEolLibraryModule() != null) {
				System.err.println(leEditor.getEolLibraryModule());
			}
		}
		
		
		graph = new Graph(parent, SWT.NONE);
		
		
		
	    // now a few nodes
	    GraphNode node1 = new GraphNode(graph, SWT.NONE, "Jim");
	    GraphNode node2 = new GraphNode(graph, SWT.NONE, "Jack");
	    GraphNode node3 = new GraphNode(graph, SWT.NONE, "Joe");
	    GraphNode node4 = new GraphNode(graph, SWT.NONE, "Bill");
	    // Lets have a directed connection
	    new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1,
	        node2);
	    // Lets have a dotted graph connection
	    new GraphConnection(graph, ZestStyles.CONNECTIONS_DOT, node2, node3);
	    // Standard connection
	    new GraphConnection(graph, SWT.NONE, node3, node1);
	    // Change line color and line width
	    GraphConnection graphConnection = new GraphConnection(graph, SWT.NONE,
	        node1, node4);
	    graphConnection.changeLineColor(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
	    // Also set a text
	    graphConnection.setText("This is a text");
	    graphConnection.setHighlightColor(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
	    graphConnection.setLineWidth(3);

	    graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
	    // Selection listener on graphConnect or GraphNode is not supported
	    // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=236528
	    graph.addSelectionListener(new SelectionAdapter() {
	      @Override
	      public void widgetSelected(SelectionEvent e) {
	        System.out.println(e);
	      }

	    });

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
		return null;
	}

}
