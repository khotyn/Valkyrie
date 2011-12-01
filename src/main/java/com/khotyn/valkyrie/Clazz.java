package com.khotyn.valkyrie;

import java.util.List;

import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.SourceFile;
import com.khotyn.valkyrie.constant.ConstantPoolInfo;
import com.khotyn.valkyrie.util.ValkyrieUtil;

/**
 * Representing the the java byte code
 * 
 * @author khotyn 2011-11-17 PM 4:45:53
 */
public class Clazz {

    public static final int        U1           = 2;
    public static final int        U2           = U1 * 2;
    public static final int        U4           = U2 * 2;
    public static final String     MAGIC_NUMBER = "CAFEBABE";
    private int                    majorVersion;
    private int                    minorVersion;
    private List<ConstantPoolInfo> constantPoolInfos;
    private List<AccessFlags>      accessFlags;
    private int                    thisClass;
    private int                    superClass;
    private List<Integer>          interfaces;
    private List<Field>            fields;
    private List<Method>           methods;
    private List<Attribute>        attributes;

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

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

    public List<ConstantPoolInfo> getConstantPoolInfos() {
        return constantPoolInfos;
    }

    public void setConstantPoolInfos(List<ConstantPoolInfo> constantPoolInfos) {
        this.constantPoolInfos = constantPoolInfos;
    }

    public List<AccessFlags> getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(List<AccessFlags> accessFlags) {
        this.accessFlags = accessFlags;
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

    public int getThisClass() {
        return thisClass;
    }

    public void setThisClass(int thisClass) {
        this.thisClass = thisClass;
    }

    public int getSuperClass() {
        return superClass;
    }

    public void setSuperClass(int superClass) {
        this.superClass = superClass;
    }

    public List<Integer> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<Integer> interfaces) {
        this.interfaces = interfaces;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String sourceFileName = null;

        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            if (attribute instanceof SourceFile) {
                sourceFileName = constantPoolInfos.get(((SourceFile) attribute).getSourcefileIndex() - 1).getString();
                sb.append("Compiled from \"" + sourceFileName + "\"\n");
                break;
            }
        }

        sb.append(getClassSignature());
        sb.append("\n  SourceFile: \"" + sourceFileName + "\"");
        sb.append("\n  minor version: " + this.minorVersion);
        sb.append("\n  major version: " + this.majorVersion);
        sb.append("\n  Constant pool:");

        for (int i = 0; i < constantPoolInfos.size(); i++) {
            ConstantPoolInfo constantPoolInfo = constantPoolInfos.get(i);

            if (constantPoolInfo == null) {
                continue;
            }

            sb.append("\nConstant #" + (i + 1) + " = " + constantPoolInfo);
        }
        sb.append("\n{");

        for (int i = 0; i < methods.size(); i++) {
            sb.append(methods.get(i));
        }
        sb.append("\n}");
        return sb.toString();

    }

    public String getClassSignature() {
        StringBuilder sb = new StringBuilder();

        sb.append(ValkyrieUtil.accessFlagsToString(accessFlags, true));

        sb.append(constantPoolInfos.get(thisClass - 1).getString() + " extends "
                  + constantPoolInfos.get(superClass - 1).getString());

        if (interfaces.size() != 0) {
            sb.append(" implements ");

            for (int i = 0; i < interfaces.size(); i++) {
                if (i != 0) sb.append(",");
                sb.append(constantPoolInfos.get(interfaces.get(i) - 1).getString());
            }
        }

        return sb.toString();
    }
}
