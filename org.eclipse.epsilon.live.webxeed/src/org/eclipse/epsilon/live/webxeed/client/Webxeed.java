package org.eclipse.epsilon.live.webxeed.client;

import java.awt.ScrollPane;

import org.eclipse.epsilon.live.webxeed.shared.WObject;
import org.eclipse.epsilon.live.webxeed.shared.WReferenceSlot;
import org.eclipse.epsilon.live.webxeed.shared.WSlot;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Webxeed implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	private final EmfModelRetrievalServiceAsync emfModelRetrievalService = GWT.create(EmfModelRetrievalService.class);
	
	protected TreeItem createTreeItem(WObject wObject) {
		WObjectTreeItem treeItem = new WObjectTreeItem();
		treeItem.setWObject(wObject);
		treeItem.setText(wObject.getTypeName());
		
		for (WSlot slot : wObject.getSlots()) {
			if (slot instanceof WReferenceSlot && ((WReferenceSlot)slot).isContainment()) {
				for (WObject value : ((WReferenceSlot)slot).getValues()) {
					treeItem.addItem(createTreeItem((WObject) value));
				}
			}
		}
		
		return treeItem;
	}
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		
		String modelUrl = Location.getParameter("modelUrl");
		String metamodelUrl = Location.getParameter("metamodelUrl");
		
		final TextBox textbox = new TextBox();
		textbox.setValue(Location.getParameter("user"));
		
		final Grid grid = new Grid();
		
		SplitLayoutPanel dockLayoutPanel = new SplitLayoutPanel();
		
		RootLayoutPanel.get().add(dockLayoutPanel);
		
		
		dockLayoutPanel.addSouth(grid, 200);
		
		final Tree tree = new Tree();
		
		emfModelRetrievalService.getEmfModel(modelUrl, metamodelUrl, new AsyncCallback<WObject>() {

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(WObject result) {
				tree.addItem(createTreeItem(result));
			}
		
		});
		
		
		tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
			
			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				WObject wObject = ((WObjectTreeItem) event.getSelectedItem()).getWObject();
				grid.resize(wObject.getSlots().size(), 2);
				
				int i = 0;
				for (WSlot wSlot : wObject.getSlots()) {
					grid.setWidget(i, 0, new HTML(wSlot.getName()));
					grid.setWidget(i, 1, new HTML(wSlot.getValues() + ""));
					i++;
				}
			}
		});
		
		dockLayoutPanel.add(new ScrollPanel(tree));
		
		/*
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText(Location.getParameter("user"));
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {

			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true); 
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
		*/
	}
}
