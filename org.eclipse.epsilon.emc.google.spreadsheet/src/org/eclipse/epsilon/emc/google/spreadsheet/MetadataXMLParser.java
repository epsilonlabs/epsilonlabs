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

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MetadataXMLParser implements ISpreadsheetMetadata {

	private Document xml;
	
	public MetadataXMLParser(Document xml) {
		this.xml = xml;
	}
	
	public List<SpreadsheetWorksheetMetadata> getWorksheets() throws IllegalArgumentException {
		List<SpreadsheetWorksheetMetadata> worksheets = new ArrayList<SpreadsheetWorksheetMetadata>();

		Element docElement = this.xml.getDocumentElement();
		NodeList nl = docElement.getElementsByTagName(ORMConstants.ORM_WORKSHEET);
		for (int i = 0; i < nl.getLength(); i++) {
			Element el = (Element) nl.item(i);
			SpreadsheetWorksheetMetadata worksheet = new SpreadsheetWorksheetMetadata();
			
			String name = el.getAttribute(ORMConstants.ORM_WORKSHEET_NAME);
			if (name.isEmpty()) {
				throw new IllegalArgumentException("A worksheet is missing its name in the configuration file.");
			} else {
				worksheet.name = name;
			}
			
			String alias = el.getAttribute(ORMConstants.ORM_WORKSHEET_ALIAS);
			if (!alias.isEmpty()) {
				worksheet.alias = alias;
			}
			
			String dtstrict = el.getAttribute(ORMConstants.ORM_WORKSHEET_DTSTRICT);
			if (!dtstrict.isEmpty()) {
				worksheet.dataTypeStrict = dtstrict;
			}
			
			String create = el.getAttribute(ORMConstants.ORM_WORKSHEET_CREATE);
			if (!create.isEmpty()) {
				worksheet.createOnLoad = create;
			}
			
			worksheets.add(worksheet);
		}
		
		return worksheets;
	}
	
	/*
	 * 
	 */
	public List<SpreadsheetColumnMetadata> getColumns(String name) throws IllegalArgumentException {
		List<SpreadsheetColumnMetadata> columns = new ArrayList<SpreadsheetColumnMetadata>();
		
		Element docElement = this.xml.getDocumentElement();
		NodeList nl = docElement.getElementsByTagName(ORMConstants.ORM_WORKSHEET);
		for (int i = 0; i < nl.getLength(); i++) {
			Element el = (Element) nl.item(i);
			String worksheetName = el.getAttribute(ORMConstants.ORM_WORKSHEET_NAME);
			
			// Get the correct worksheet
			if (name.equals(worksheetName)) {
				NodeList cnl = el.getChildNodes();
				for (int c = 0; c < cnl.getLength(); c++) {
					Node col = cnl.item(c);
					if (col.getNodeName().equals(ORMConstants.ORM_COLUMN)) {
						NamedNodeMap nls = col.getAttributes();
						Node index = nls.getNamedItem(ORMConstants.ORM_COL_INDEX);
						Node colName = nls.getNamedItem(ORMConstants.ORM_COL_NAME);
						Node alias = nls.getNamedItem(ORMConstants.ORM_COL_ALIAS);
						Node type = nls.getNamedItem(ORMConstants.ORM_COL_DATA_TYPE);
						Node many = nls.getNamedItem(ORMConstants.ORM_COL_MANY);
						Node delimiter = nls.getNamedItem(ORMConstants.ORM_COL_DELIMITER);
						
						SpreadsheetColumnMetadata column = new SpreadsheetColumnMetadata();
						if (index != null) {
							String sIndex = index.getNodeValue();
							if (sIndex != null && !sIndex.isEmpty()) {
								column.index = sIndex;
							}
						}
						
						if (colName != null) {
							String sName = colName.getNodeValue();
							if (sName != null && !sName.isEmpty()) {
								column.name = sName;
							}
						}
						
						if (column.index == null && column.name == null) {
							throw new IllegalArgumentException("Column is missing both index and name in the " +
															   "configuration file.");
						}
						
						if (alias != null) {
							column.alias = alias.getNodeValue();
						}
						
						if (type != null) {
							column.dataType = type.getNodeValue();
						}
						
						if (many != null) {
							column.many = many.getNodeValue();
						}
						
						if (delimiter != null) {
							column.delimiter = delimiter.getNodeValue();
						}
						
						columns.add(column);
					}
				}
				
				break;
			}
		}
		
		return columns;
	}
	
	/*
	 *
	 */
	public List<SpreadsheetReferenceMetadata> getReferences() throws IllegalArgumentException {
		List<SpreadsheetReferenceMetadata> references = new ArrayList<SpreadsheetReferenceMetadata>();
		Element docElement = this.xml.getDocumentElement();
		NodeList nl = docElement.getElementsByTagName(ORMConstants.ORM_REFERENCE);
		
		for (int i = 0; i < nl.getLength(); i++) {
			Element el = (Element) nl.item(i);
			
			SpreadsheetReferenceMetadata obj = new SpreadsheetReferenceMetadata();
			String source = el.getAttribute(ORMConstants.ORM_REF_SOURCE);
			String target = el.getAttribute(ORMConstants.ORM_REF_TARGET);
			
			if (source.isEmpty() || target.isEmpty()) {
				throw new IllegalArgumentException("Reference is missing source or target in the configuration file.");
			}
			
			obj.source = source;
			obj.target = target;
			
			String many = el.getAttribute(ORMConstants.ORM_REF_MANY);
			if (!many.isEmpty()) {
				obj.many = many;
			}
			
			String cascade = el.getAttribute(ORMConstants.ORM_REF_CASCADE);
			if (!cascade.isEmpty()) {
				obj.cascadeChanges = cascade;
			}
			
			references.add(obj);
		}
		return references;
	}
	
}
