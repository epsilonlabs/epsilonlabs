/*
 * Copyright (c) 2011 MetaCase Consulting
 * Released under the MIT license. See the file license.txt for details. 
 */

/**
 * MetaEditAPI.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.eclipse.epsilon.emc.metaedit.api;

public interface MetaEditAPI extends javax.xml.rpc.Service {
    public java.lang.String getMetaEditAPIPortAddress();

    public MetaEditAPIPortType getMetaEditAPIPort() throws javax.xml.rpc.ServiceException;

    public MetaEditAPIPortType getMetaEditAPIPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
