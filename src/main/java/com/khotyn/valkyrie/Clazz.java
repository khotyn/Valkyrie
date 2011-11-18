package com.khotyn.valkyrie;

import java.util.List;

/**
 * Representing the the java byte code
 * 
 * @author khotyn 2011-11-17 ����4:45:53
 */
public class Clazz {

    public static final String MAGIC_NUMBER = "0xCAFEBABE";
    private int                majorVersion;
    private int                minorVersion;
    private List<CPInfo>       cpInfos;
    private List<AccessFlag>   accessFlags;
    private String             thisClass;
    private String             superClass;
    private List<String>       interfaces;
    private List<String>       fields;
    private List<Method>       methods;
    private List<Attribute>    attributes;

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public List<CPInfo> getCpInfos() {
        return cpInfos;
    }

    public void setCpInfos(List<CPInfo> cpInfos) {
        this.cpInfos = cpInfos;
    }

    public List<AccessFlag> getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(List<AccessFlag> accessFlags) {
        this.accessFlags = accessFlags;
    }

    public String getThisClass() {
        return thisClass;
    }

    public void setThisClass(String thisClass) {
        this.thisClass = thisClass;
    }

    public String getSuperClass() {
        return superClass;
    }

    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    public List<String> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<String> interfaces) {
        this.interfaces = interfaces;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public static String getMagicNumber() {
        return MAGIC_NUMBER;
    }
}