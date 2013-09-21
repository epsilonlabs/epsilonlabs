/**
 * Calculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.calculatorservice;

public interface Calculator extends java.rmi.Remote {
    public int add(int x, int y) throws java.rmi.RemoteException;
    public java.lang.String getVersion() throws java.rmi.RemoteException;
    public int[] range(int from, int to) throws java.rmi.RemoteException;
    public com.example.calculatorservice.Neighbours getNeighbours(int x) throws java.rmi.RemoteException;
    public int secureAdd(int x, int y) throws java.rmi.RemoteException;
}
