/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martins Francis - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.google.spreadsheet;

import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.spreadsheet.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.google.spreadsheet.ISpreadsheetMetadata.SpreadsheetColumnMetadata;
import org.eclipse.epsilon.emc.google.spreadsheet.ISpreadsheetMetadata.SpreadsheetReferenceMetadata;
import org.eclipse.epsilon.emc.google.spreadsheet.ISpreadsheetMetadata.SpreadsheetWorksheetMetadata;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class GSModel extends SpreadsheetModel {
	
	// Identifiers used for receiving parameters from Epsilon Development Tools
	public static final String USERNAME = "GSUsername";
	public static final String PASSWORD = "GSPassword";
	public static final String CONFIGURATION_FILE = "GSConfigurationFile";
	
	protected SpreadsheetService spreadsheetService;
	protected SpreadsheetEntry spreadsheetEntry;
	
	private String username;
	private String password;
	private File configurationFile;
	private Document configurationDoc;
	
	public GSModel() {
		super();
		
		this.spreadsheetService = null;
		this.spreadsheetEntry = null;
		this.username = null;
		this.password = null;
		this.configurationFile = null;
		this.configurationDoc = null;
	}
	
	public static void main(String[] args) throws Exception {
		GSModel model = new GSModel();
		if (args.length == 5) {
			model.setUsername(args[0]);
			model.setPassword(args[1]);
			model.setSpreadsheetName(args[2]);
			model.setConfigurationFile(args[3]);
			model.setModelName(args[4]); // Model name
		}
		model.load();
		
		System.out.println("*** Executing EOL Code...");
		EolModule module = new EolModule();
		//module.parse("Room.all.people.println();");
		module.parse("Room.all.v_people.println();");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}
	
	/*
	 * Sets the name of the model
	 */
	public void setModelName(String name) {
		super.setName(name);
	}
	
	/*
	 * Sets the Google account username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/*
	 * Sets the Google account password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * Sets the configuration file and XML Document.
	 */
	public void setConfigurationFile(String configurationFilePath) throws ParserConfigurationException, SAXException, IOException {
		if (configurationFilePath != null && !configurationFilePath.isEmpty()) {
			this.configurationFile = new File(configurationFilePath);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			this.configurationDoc = documentBuilder.parse(this.configurationFile);
		}
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		// This method is called when the model is created from the Epsilon Development Tools
		super.load(properties, basePath);
		
		try {
			// Google account username
			this.setUsername(properties.getProperty(GSModel.USERNAME));
			
			// Google account password	
			this.setPassword(properties.getProperty(GSModel.PASSWORD));
			
			// Configuration file
		    String filePath = properties.getProperty(GSModel.CONFIGURATION_FILE);
			if (filePath != null && filePath.trim().length() > 0) {
				if (basePath != null) filePath = basePath + filePath;
				this.setConfigurationFile(filePath);
			}
		} catch(Exception e) {
			throw new EolModelLoadingException(e, this);
		}
		
		this.load();
	}

	@Override
	public void load() throws EolModelLoadingException {
		try {
			// Authenticating
			System.out.println("Authenticating...");
			this.spreadsheetService = new SpreadsheetService("EpsilonGSModel_"+this.name);
			this.spreadsheetService.setUserCredentials(this.username, this.password);
			
			// Load the spreadsheet
			System.out.println("Loading spreadsheet '" + this.spreadsheetName + "'...");
			URL SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
			SpreadsheetQuery spreadsheetQuery = new SpreadsheetQuery(SPREADSHEET_FEED_URL);
			spreadsheetQuery.setTitleQuery(this.spreadsheetName);
			spreadsheetQuery.setTitleExact(true); // Use the exact spreadsheet name
		    SpreadsheetFeed feed = spreadsheetService.getFeed(spreadsheetQuery, SpreadsheetFeed.class);
		    List<SpreadsheetEntry> spreadsheets = feed.getEntries();
		    
		    if (spreadsheets.isEmpty()) {
		    	throw new Exception("Google could not find a spreadsheet with the name '" + this.spreadsheetName + "'");
		    }
		    
		    if (spreadsheets.size() > 1) {
		    	System.out.println("Warning: Found " + Integer.toString(spreadsheets.size()) + " spreadsheets " +
		    					   "called '" + this.spreadsheetName + "'; selecting the first one from the list");
		    }
		    
		    // Set the spreadsheet
		    this.spreadsheetEntry = spreadsheets.get(0);
		    
		    // Load schemas from Google
		    System.out.println("Loading worksheets from Google...");
		    List<WorksheetEntry> worksheetFeedEntries = this.spreadsheetEntry.getWorksheets();
		    for (WorksheetEntry we : worksheetFeedEntries) {
		    	GSWorksheet gsw = new GSWorksheet(this, we, true);
		    	this.addWorksheet(gsw);
		    }
		    
		    // Load ORM meta-data if specified
		    if (this.configurationDoc != null) {
		    	System.out.println("Loading the configuration file...");
		    	metadata = new MetadataXMLParser(this.configurationDoc);
		    	
		    	// Get all worksheet and column ORM meta-data
		    	for (SpreadsheetWorksheetMetadata worksheet : metadata.getWorksheets()) {
		    		System.out.print("\tLoading worksheet '" + worksheet.name + "'...");
		    		GSWorksheet gsw = (GSWorksheet) this.getWorksheetByType(worksheet.name);
		    		boolean create = false;
					if (gsw == null) {
						// Determine whether the worksheet needs to be created in the spreadsheet
						String createOnLoad = worksheet.createOnLoad;
						create = (createOnLoad != null && !createOnLoad.isEmpty()) 
								  ? Boolean.parseBoolean(createOnLoad) 
								  : SpreadsheetConstants.DEFAULT_WORKSHEET_CREATE_ON_LOAD;
						
						// Create a Google representation of the new worksheet
						WorksheetEntry we = new WorksheetEntry();
					    we.setTitle(new PlainTextConstruct(worksheet.name));
					    we.setColCount(SpreadsheetConstants.DEFAULT_WORKSHEET_COLS);
					    we.setRowCount(SpreadsheetConstants.DEFAULT_WORKSHEET_ROWS);
					    
					    // Create a local representation of the worksheet
						gsw = new GSWorksheet(this, we, false);
						
						this.addWorksheet(gsw);
					}
					
					gsw.addMetadata(worksheet);
					
					// Get column ORM meta-data
					System.out.println("Loading columns...");
					for (SpreadsheetColumnMetadata column : metadata.getColumns(worksheet.name)) {
						gsw.addColumn(column);
					}
					
					// Create the worksheet in the spreadsheet
					if (create) gsw.createInSpreadsheet();
		    	}
		    	
		    	System.out.println("WORKSHEETS: " + this.getWorksheets());
			    
		    	// Get references from the file
		    	System.out.println("Loading references...");
		    	for (SpreadsheetReferenceMetadata reference : metadata.getReferences()) {
		    		SpreadsheetReference ref = new SpreadsheetReference(this,reference);
		    		this.addReference(ref);
		    	}
			    
			    System.out.println("REFERENCES: "+this.getReferences());
		    }
		    
		    System.out.println("Spreadsheet '" + this.spreadsheetName + "' has been loaded. " +
		    				   "Worksheets: " + this.getWorksheets().size() + "; " +
		    				   "References: " + this.getWorksheets().size() + "; ");
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	// The following are all supported by Google (but not necessarily by the AST)
	public static final ArrayList<String> OPERATORS = new ArrayList<String>(Arrays.asList("=","==","<>","<","<=",">",">="));
	public static final ArrayList<String> CONNECTIVES = new ArrayList<String>(Arrays.asList("and","or"));
	private static final String FIND_EX_MSG = "Invalid search query format.";

	@Override
	public Collection<SpreadsheetRow> find(Variable iterator, AST ast, IEolContext context) throws EolRuntimeException {
		try {
			// Get the specified worksheet
			GSWorksheet worksheet = (GSWorksheet) this.getWorksheetByType(iterator.getType().getName());
			
			if (worksheet == null) {
				throw new EolRuntimeException("Worksheet '" + iterator.getType().getName() + "' coud not be found " +
											  "in spreadsheet '" + this.spreadsheetName + "'.");
			}
			
			if (!worksheet.existsInSpreadsheet) {
				throw new EolRuntimeException("Worksheet " + worksheet.getName() + " does not exist " +
											  "in spreadsheet '" + this.spreadsheetName + "'.");
			}
			
			// Load the unique Google column ids, if necessary
			if (!worksheet.hasGoogleIdsSet) {
				worksheet.getGoogleColumnIds();
			}
			
			// Iterate over the AST
			String expr = "";
			if (GSModel.CONNECTIVES.contains(ast.getText())) {
				expr = this.recursiveFind(iterator, ast.getFirstChild(), context, ast.getText());
			} else {
				expr = this.recursiveFind(iterator, ast, context, "");
			}
			
			System.out.println("SEARCHABLE MODEL EXPRESSION: " + expr);
			
			// Get rows from the worksheet
			List<SpreadsheetRow> rows = new ArrayList<SpreadsheetRow>();
			URL listFeedUrl = new URI(worksheet.worksheetEntry.getListFeedUrl().toString() + 
									  "?sq=" + URLEncoder.encode(expr,"UTF-8")).toURL();
			ListFeed lf = this.spreadsheetService.getFeed(listFeedUrl, ListFeed.class); // This is slow
			for (ListEntry row : lf.getEntries()) {
				rows.add(new GSRow(worksheet, row));
			}
		    
		    return rows;
		} catch(EolRuntimeException e) {
			if (e.getMessage().equals(GSModel.FIND_EX_MSG)) {
				throw new EolRuntimeException("Only queries of the form find(w:Worksheet | w.column = <value>) " +
											  "are supported by this driver.");
			} else {
				throw new EolRuntimeException(e.getMessage());
			}
		} catch(Exception e) {
			throw new EolRuntimeException(e.getMessage());
		}
	}
	
	private String recursiveFind(Variable iterator, AST ast, IEolContext context, String parentOp) throws Exception {
		if (ast == null) return "";
		
		if (GSModel.CONNECTIVES.contains(ast.getText())) {
			// Recursively get the LHS child of the parent node
			String valueLeft = this.recursiveFind(iterator, ast.getFirstChild(), context, ast.getText());
			
			// Recursively get the RHS child of the parent node
			String valueRight = this.recursiveFind(iterator, ast.getNextSibling(), context, ast.getText());
			
			// Construct the expression
			String expr = valueLeft;
			if (!valueRight.isEmpty()) {
				expr = "(" + valueLeft + ") " + parentOp + " (" + valueRight + ")";
			}
			return expr;
		} else if (GSModel.OPERATORS.contains(ast.getText()) && ast.getType() == EolParser.OPERATOR && ast.getChildCount() == 2) {
			String valueLeft = "";
			
			// Extract the property and value
			AST pointAst = ast.getFirstChild();
			if (pointAst != null && pointAst.getType() == EolParser.POINT) {
				// Ensure that the worksheet iterator name matches the one of the property
				String iteratorName = iterator.getName();
				if (pointAst.getFirstChild().getText().equals(iteratorName)) {
					// Locate the specified column in the specified worksheet
					SpreadsheetWorksheet worksheet = this.getWorksheetByType(iterator.getType().getName());
					String columnType = pointAst.getFirstChild().getNextSibling().getText();
					SpreadsheetColumn column = worksheet.getColumn(columnType);
					
					if (column == null) {
						throw new EolRuntimeException("Column '" + columnType + "' not found in worksheet '" + 
													  worksheet.getName() + "'.");
					}
					
					// Execute the specified value
					String value = context.getExecutorFactory().executeAST(pointAst.getNextSibling(), context) + "";
					
					// Enclose strings in quotes
					GSColumn c = (GSColumn) column;
					if (c.getDataType() == SpreadsheetDataType.STRING) {
						value = "\"" + value + "\"";
					}
					
					// Construct the expression
					valueLeft += c.getGoogleColumnId() + " " + ast.getText() + " " + value;
				} else {
					throw new EolRuntimeException(GSModel.FIND_EX_MSG);
				}
				
			} else {
				throw new EolRuntimeException(GSModel.FIND_EX_MSG);
			}
			
			// There might be a further AST node
			String valueRight = this.recursiveFind(iterator, ast.getNextSibling(), context, "");
			
			// Construct the expression
			String expr = valueLeft;
			if (valueRight != null && !valueRight.isEmpty()) {
				expr = "(" + valueLeft + " " + parentOp + " " + valueRight + ")";
			}
			return expr;
		} else {
			throw new EolRuntimeException(GSModel.FIND_EX_MSG);
		}
	}

	@Override
	public Object findOne(Variable iterator, AST ast, IEolContext context)
			throws EolRuntimeException {
		Collection<SpreadsheetRow> results = find(iterator, ast, context);
		if (results != null && results.iterator().hasNext()) {
			return results.iterator().next();
		}
		else return null;
	}
}
