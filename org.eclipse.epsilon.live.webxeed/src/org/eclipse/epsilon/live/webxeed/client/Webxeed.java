package org.eclipse.epsilon.live.webxeed.client;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.live.webxeed.shared.WObject;
import org.eclipse.epsilon.live.webxeed.shared.WReferenceSlot;
import org.eclipse.epsilon.live.webxeed.shared.WSlot;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.RowStyles;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Webxeed implements EntryPoint {
	
	private final EmfModelRetrievalServiceAsync emfModelRetrievalService = GWT.create(EmfModelRetrievalService.class);
	protected String imagesUrl = null;
	protected String imageFormat = null;
	protected ListDataProvider<WSlot> propertiesGridDataProvider = null;
	protected CellTable.Resources propertiesTableResources = (CellTable.Resources) GWT.create(PropertiesTableResources.class);
	protected List<WObject> wObjects = new ArrayList<WObject>();
	
	@UiField(provided=true)
	protected CellTable<WSlot> propertiesGrid = new CellTable<WSlot>(100, propertiesTableResources);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		String modelUrl = Location.getParameter("modelUrl");
		String metamodelUrl = Location.getParameter("metamodelUrl");
		imagesUrl = getParameter("imagesUrl", "images");
		imageFormat = getParameter("format", "gif");
		
		propertiesGridDataProvider = new ListDataProvider<WSlot>();
		propertiesGridDataProvider.addDataDisplay(propertiesGrid);
		
		TextColumn<WSlot> nameColumn = new TextColumn<WSlot>() {

			@Override
			public String getValue(WSlot slot) {
				return slot.getName();
			}
		};
		propertiesGrid.addColumn(nameColumn, "Name");
		propertiesGrid.setColumnWidth(nameColumn, "100px");
		nameColumn.setCellStyleNames("propertyName");
		
		TextColumn<WSlot> valueColumn = new TextColumn<WSlot>() {
			
			public Widget getWidget(WSlot slot) {
				if (slot instanceof WReferenceSlot) {
					String label = "";
					for (Object value : slot.getValues()) {
						label = label + "<a name='ref" + wObjects.indexOf((WObject) value) + "' target='#'>" + ((WObject)value).getReferenceLabel() + "</a>, ";
					}
					if (label.endsWith(", ")) label = label.substring(0, label.length()-2);
					return new HTML(label);
				}
				else {
					String label = "";
					for (Object value : slot.getValues()) {
						label = label + value + ", ";
					}
					if (label.endsWith(", ")) label = label.substring(0, label.length()-2);
					return new HTML(label);
				}
			}
			

			@Override
			public String getValue(WSlot slot) {
				return getWidget(slot).getElement().getInnerHTML();
			}
			
			@Override
			public void render(Context context, WSlot slot, SafeHtmlBuilder sb) {
				sb.append(SafeHtmlUtils.fromTrustedString(getWidget(slot).getElement().getInnerHTML()));
			}
			
		};
		propertiesGrid.addColumn(valueColumn, "Value");
		
		propertiesGrid.setStyleName("propertiesTable");
		propertiesGrid.setRowStyles(new RowStyles<WSlot>() {
			
			@Override
			public String getStyleNames(WSlot row, int rowIndex) {
				return "property";
			}
		});
		
		SplitLayoutPanel dockLayoutPanel = new SplitLayoutPanel();
		RootLayoutPanel.get().add(dockLayoutPanel);
		//ResizeLayoutPanel resizeLayoutPanel = new ResizeLayoutPanel();
		//resizeLayoutPanel.add(propertiesGrid);
		dockLayoutPanel.addSouth(new ScrollPanel(propertiesGrid), 200);
		
		final Tree tree = new Tree();
		emfModelRetrievalService.getEmfModel(modelUrl, metamodelUrl, new AsyncCallback<WObject>() {

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(WObject result) {
				System.err.println("NPE: " + (result == null));
				tree.addItem(createTreeItem(result));
			}
		
		});
		
		
		tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
			
			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				
				WObject wObject = ((WObjectTreeItem) event.getSelectedItem()).getWObject();
				propertiesGridDataProvider.setList(wObject.getSlots());
				
				/*
				for (Element e : DOMUtil.findElementsForName(propertiesGrid.getElement(), "ref")) {
					System.err.println();
				}*/
				
				//propertiesGrid.setRowCount(wObject.getSlots().size(), true);
				//propertiesGrid.setRowData(wObject.getSlots());
				//propertiesGrid.redraw();
				
				/*
				propertiesGrid.resize(wObject.getSlots().size()+1, 2);
				
				propertiesGrid.setWidget(0, 0, new HTML("Name"));
				propertiesGrid.setWidget(0, 1, new HTML("Value"));
				
				int i = 1;
				for (WSlot wSlot : wObject.getSlots()) {
					propertiesGrid.setWidget(i, 0, new HTML(wSlot.getName()));
					propertiesGrid.setWidget(i, 1, new HTML(wSlot.getValues() + ""));
					i++;
				}*/
			}
		});
		
		Event.addNativePreviewHandler(new NativePreviewHandler() {
			
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				if (event.getTypeInt() == Event.ONCLICK) {
					Object target = Event.as(event.getNativeEvent()).getEventTarget();
					if (target instanceof Element) {
						Element element = (Element) target;
						if (element.getNodeName().equalsIgnoreCase("a") && DOM.getElementProperty(element, "name").startsWith("ref")) {
							String wObjectId = DOM.getElementProperty(element, "name").substring(3);
							System.err.println("W:" + wObjectId);
							//System.err.println(wObjects.get(Integer.parseInt(wObjectId)));
						}
					}
					
				}
				/*
				if (Event.as(event).getTypeInt() == Event.ONCLICK) {
					//
				}*/
			}
		});
		
		dockLayoutPanel.add(new ScrollPanel(tree));
		
	}
	
	protected Widget createWidget(WObject wObject) {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.add(new Image(imagesUrl + "/" + wObject.getIcon() + "."  + imageFormat));
		HTML treeItemLabel = new HTML(wObject.toString() + " (" + wObject.getTypeName() + ")");
		treeItemLabel.setStyleName("treeItem");
		horizontalPanel.add(treeItemLabel);
		return horizontalPanel;
	}
	
	protected TreeItem createTreeItem(WObject wObject) {
		WObjectTreeItem treeItem = new WObjectTreeItem();
		treeItem.setWObject(wObject);
		wObject.setId(wObjects.size());
		wObjects.add(wObject);
		treeItem.setWidget(createWidget(wObject));
		
		for (WSlot slot : wObject.getSlots()) {
			if (slot instanceof WReferenceSlot && ((WReferenceSlot)slot).isContainment()) {
				for (WObject value : ((WReferenceSlot)slot).getValues()) {
					treeItem.addItem(createTreeItem((WObject) value));
				}
			}
		}
		
		return treeItem;
	}
	
	protected String getParameter(String name, String def) {
		if (Location.getParameter(name) != null) {
			return Location.getParameter(name);
		}
		else { return def; }
	}

}
