/**
 * Neighbours.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.calculatorservice;

public class Neighbours  implements java.io.Serializable {
    private int next;

    private int previous;

    public Neighbours() {
    }

    public Neighbours(
           int next,
           int previous) {
           this.next = next;
           this.previous = previous;
    }


    /**
     * Gets the next value for this Neighbours.
     * 
     * @return next
     */
    public int getNext() {
        return next;
    }


    /**
     * Sets the next value for this Neighbours.
     * 
     * @param next
     */
    public void setNext(int next) {
        this.next = next;
    }


    /**
     * Gets the previous value for this Neighbours.
     * 
     * @return previous
     */
    public int getPrevious() {
        return previous;
    }


    /**
     * Sets the previous value for this Neighbours.
     * 
     * @param previous
     */
    public void setPrevious(int previous) {
        this.previous = previous;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Neighbours)) return false;
        Neighbours other = (Neighbours) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.next == other.getNext() &&
            this.previous == other.getPrevious();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getNext();
        _hashCode += getPrevious();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Neighbours.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://calculatorservice.example.com", "Neighbours"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("next");
        elemField.setXmlName(new javax.xml.namespace.QName("http://calculatorservice.example.com", "next"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previous");
        elemField.setXmlName(new javax.xml.namespace.QName("http://calculatorservice.example.com", "previous"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
