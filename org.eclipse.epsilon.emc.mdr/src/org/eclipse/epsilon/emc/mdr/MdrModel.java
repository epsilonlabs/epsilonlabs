/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.mdr;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.jmi.model.ModelPackage;
import javax.jmi.model.MofClass;
import javax.jmi.model.MofPackage;
import javax.jmi.reflect.RefClass;
import javax.jmi.reflect.RefEnum;
import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotAnEnumerationValueException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.models.IReflectiveModel;
import org.eclipse.epsilon.eol.models.Model;
import org.netbeans.api.mdr.MDRepository;
import org.netbeans.api.xmi.XMIReader;
import org.netbeans.api.xmi.XMIReaderFactory;
import org.netbeans.api.xmi.XMIWriter;
import org.netbeans.api.xmi.XMIWriterFactory;
import org.netbeans.mdr.NBMDRepositoryImpl;


public class MdrModel extends AbstractMdrModel {
	
	protected XMIReader xmiReader;
	protected XMIWriter xmiWriter;
	
	protected String modelFile = "";
	protected String metamodelFile = "";
	protected String extent = "";
	protected String extentInstance = "";
	protected RefPackage refPackage = null;
	protected MDRepository repository;
	private boolean isMetamodel = false;
	
	public MdrModel(){
		
		cacheElements = true;
		
		System.setProperty("org.netbeans.lib.jmi.Logger.fileName", "mdr.log");
		System.setProperty("org.openide.util.Lookup", "org.openide.util.lookup.MdrModelLookup");
		
		xmiReader = XMIReaderFactory.getDefault().createXMIReader();
		xmiWriter = XMIWriterFactory.getDefault().createXMIWriter();
		
		idManager = new MdrIdManager();
		xmiReader.getConfiguration().setReferenceResolver(idManager);
		xmiWriter.getConfiguration().setReferenceProvider(idManager);
		
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {	
		super.load(properties, basePath);
		this.metamodelFile = basePath + properties.getProperty("metamodelFile");
		this.modelFile = basePath + properties.getProperty("modelFile");
		this.isMetamodel = Boolean.parseBoolean(properties.getProperty("isMetamodel"));
		this.extent = properties.getProperty("extent");
		load();
	}
	
	public void load() throws EolModelLoadingException{
		try {
			loadImpl();
		}
		catch (Exception ex){
			throw new EolModelLoadingException(ex, this);
		}
	}
	
	private void loadImpl() throws Exception{
		
		String modelFile = "";
		String metaModelFile = "";
		String extent = "";
		
		if (this.isMetamodel()){
			modelFile = convertToUri(this.metamodelFile);
			metaModelFile = convertToUri(this.metamodelFile);
			extent = "MOF";
		}
		else {
			modelFile = convertToUri(this.modelFile);
			metaModelFile = convertToUri(this.metamodelFile);
			extent = this.extent;
		}
		
		HashMap args = new HashMap();
		String storageId = MdrUtil.createStorageId();
		args.put("storage", "org.netbeans.mdr.persistence.memoryimpl.StorageFactoryImpl");
		args.put(org.netbeans.mdr.persistence.memoryimpl.StorageFactoryImpl.STORAGE_ID, storageId);
		repository = new NBMDRepositoryImpl(args);
		
		extentInstance = extent + "Instance";
		
		try {
			refPackage = repository.getExtent(extentInstance);
		}
		catch (Exception ex){ }
		
		if (refPackage == null) {
			try{
				MofPackage mofPackage = getModelPackage(extent, metaModelFile);
				refPackage = repository.createExtent(extentInstance, mofPackage);
			}
			catch (Exception ex){
				throw ex;
			}
		}
		
		if (this.readOnLoad){

			try {
				xmiReader.read(modelFile, refPackage);
			}
			catch (Exception ex){ }
		}
	}
	
	// TODO: Fix package discovery
	private MofPackage getMofPackage(ModelPackage extent, String extentName) {
		Iterator it = extent.getMofPackage().refAllOfClass().iterator();
		while (it.hasNext()) {
			MofPackage pkg = (MofPackage) it.next();
			if (pkg.getContainer() == null && extentName.equals(pkg.getName())) {
				return pkg;
			}
		}
		return null;
	}

	private MofPackage getModelPackage(String extent, String metamodelfile) throws Exception {
		ModelPackage modelMM = (ModelPackage) repository.getExtent(extent);
		if (modelMM == null) {
			modelMM = (ModelPackage) repository.createExtent(extent);
		}
		MofPackage result = getMofPackage(modelMM, extent);
		if (result == null) {
			xmiReader.read(metamodelfile.toString(),
					modelMM);
		}
		result = getMofPackage(modelMM, extent);
		return result;
	}

	public boolean store(String fileName) {
		
		try {
			FileOutputStream fs = new FileOutputStream(fileName);
			xmiWriter.write(fs, refPackage, null);
			fs.flush();
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void dispose(){
		super.dispose();
		repository.shutdown();
		repository = null;
		this.xmiReader = null;
		this.xmiWriter = null;
	}
	
	public RefPackage getImpl(){
		return refPackage;
	}

	public String getExtent() {
		return extent;
	}

	public String getMetamodelFile() {
		return metamodelFile;
	}

	public void setExtent(String extent) {
		this.extent = extent;
	}

	public void setMetamodelFile(String metaModelFile) {
		this.metamodelFile = metaModelFile;
	}

	public void setModelFile(String modelFile) {
		this.modelFile = modelFile;
	}

	public String getModelFile() {
		return modelFile;
	}
	
	public String getMetaModel(){
		return extent;
	}
	
	public boolean isMetamodel(){
		return isMetamodel;
	}

	public void setMetamodel(boolean isMetaModel){
		this.isMetamodel = isMetaModel;
	}

	public boolean store() {
		return store(this.modelFile);
	}
	
	private String convertToUri(String fileName){
		try {
			return new File(fileName).toURL().toString();
		} catch (MalformedURLException e) {
			// Ignore
		}
		return "";
	}

	@Override
	public RefPackage getRefPackage() {
		return refPackage;
	}
}

