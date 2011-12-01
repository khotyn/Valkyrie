package com.khotyn.valkyrie;

import java.util.List;

import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.Code;
import com.khotyn.valkyrie.attribute.Deprecated;
import com.khotyn.valkyrie.attribute.LineNumberTable;
import com.khotyn.valkyrie.attribute.RuntimeVisibleAnnotations;
import com.khotyn.valkyrie.util.ValkyrieUtil;

/**
 * Representing a method
 * 
 * @author khotyn 2011-11-17 PM 5:16:00
 */
public class Method implements ClazzAware {

    private List<AccessFlags> accessFlags;
    private int               nameIndex;
    private int               descriptorIndex;
    private List<Attribute>   attributes;
    private Clazz             clazz;

    public Method(Clazz clazz){
        this.clazz = clazz;
    }

    public List<AccessFlags> getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(List<AccessFlags> accessFlags) {
        this.accessFlags = accessFlags;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public Clazz getClazz() {
        return clazz;
    }

    @Override
    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String descriptor = clazz.getConstantPoolInfos().get(descriptorIndex - 1).getString();
        int paramStart = descriptor.indexOf('(') + 1;
        int paramEnd = descriptor.indexOf(')');
        List<String> parameters = ValkyrieUtil.getTypes(descriptor.substring(paramStart, paramEnd));
        String returnType = ValkyrieUtil.getType(descriptor.substring(paramEnd + 1, descriptor.length()));
        sb.append("\n" + ValkyrieUtil.accessFlagsToString(accessFlags, false) + returnType + " "
                  + clazz.getConstantPoolInfos().get(nameIndex - 1).getString() + "(");

        for (int i = 0; i < parameters.size(); i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(parameters.get(i));
        }
        sb.append(");\n  Code:");

        for (int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i) instanceof Code) {
                Code code = (Code) attributes.get(i);
                sb.append("\n    Stack=" + code.getMaxStack() + ", Locals=" + code.getMaxLocals() + ", Args_size="
                          + (accessFlags.contains(AccessFlags.ACC_STATIC) ? parameters.size() : parameters.size() + 1));
                sb.append("\n    Code=" + code.getCode());
            }

            if (attributes.get(i) instanceof LineNumberTable) {
                LineNumberTable lineNumberTable = (LineNumberTable) attributes.get(i);
                sb.append("\n  LineNumberTable:");
                for (int j = 0; j < lineNumberTable.getLineNumberTable().size(); j++) {
                    sb.append("\n   " + lineNumberTable.getLineNumberTable().get(j).getStartPC() + ": "
                              + lineNumberTable.getLineNumberTable().get(j).getLineNumber());
                }
            }

            if (attributes.get(i) instanceof Deprecated) {
                sb.append("\n  Deprecated: true");
            }

            if (attributes.get(i) instanceof RuntimeVisibleAnnotations) {
                RuntimeVisibleAnnotations runtimeVisibleAnnotations = (RuntimeVisibleAnnotations) attributes.get(i);
                sb.append("\n  RuntimeVisibleAnnotations: length = " + runtimeVisibleAnnotations.getLength());
                for (int j = 0; j < runtimeVisibleAnnotations.getAnnotations().size(); j++) {
                    sb.append("\n   " + runtimeVisibleAnnotations.getAnnotations().get(j));
                }
            }
        }

        return sb.append("\n").toString();
    }
}
