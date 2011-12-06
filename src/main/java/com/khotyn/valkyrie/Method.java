package com.khotyn.valkyrie;

import java.util.List;

import com.khotyn.valkyrie.attribute.AnnotationDefault;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.Code;
import com.khotyn.valkyrie.attribute.Deprecated;
import com.khotyn.valkyrie.attribute.Exceptions;
import com.khotyn.valkyrie.attribute.LineNumberTable;
import com.khotyn.valkyrie.attribute.LocalVariable;
import com.khotyn.valkyrie.attribute.LocalVariableTable;
import com.khotyn.valkyrie.attribute.RuntimeInvisibleAnnocations;
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
        String methodName = clazz.getConstantPoolInfos().get(nameIndex - 1).getString();

        if (!methodName.equals("<clinit>")) {
            sb.append("\n"
                      + ValkyrieUtil.accessFlagsToString(accessFlags, false)
                      + (methodName.equals("<init>") ? clazz.getConstantPoolInfos().get(clazz.getThisClass() - 1).getString() : (returnType
                                                                                                                                 + " " + methodName))
                      + "(");

            for (int i = 0; i < parameters.size(); i++) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(parameters.get(i));
            }
            sb.append(");");
        } else {
            sb.append("\nstatic {};");
        }

        sb.append("\n  Code:");

        for (int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i) instanceof Code) {
                Code code = (Code) attributes.get(i);
                sb.append("\n   Stack=" + code.getMaxStack() + ", Locals=" + code.getMaxLocals() + ", Args_size="
                          + (accessFlags.contains(AccessFlags.ACC_STATIC) ? parameters.size() : parameters.size() + 1));
                sb.append("\n   Code=" + code.getCode());

                for (int j = 0; j < code.getAttributes().size(); j++) {
                    if (code.getAttributes().get(j) instanceof LineNumberTable) {
                        LineNumberTable lineNumberTable = (LineNumberTable) code.getAttributes().get(j);
                        sb.append("\n  LineNumberTable:");

                        for (int k = 0; k < lineNumberTable.getLineNumberTable().size(); k++) {
                            sb.append("\n   line " + lineNumberTable.getLineNumberTable().get(k).getLineNumber() + ": "
                                      + lineNumberTable.getLineNumberTable().get(k).getStartPC());
                        }
                    }

                    if (code.getAttributes().get(j) instanceof LocalVariableTable) {
                        LocalVariableTable localVariableTable = (LocalVariableTable) code.getAttributes().get(j);
                        sb.append("\n\n  LocalVariableTable:");
                        sb.append("\n   Start\tLength\tSlot\tName\tSignature");

                        for (int k = 0; k < localVariableTable.getLocalVariableTable().size(); k++) {
                            LocalVariable localVariable = localVariableTable.getLocalVariableTable().get(k);

                            sb.append("\n   "
                                      + localVariable.getStartPC()
                                      + "\t\t"
                                      + localVariable.getLength()
                                      + "\t"
                                      + localVariable.getIndex()
                                      + "\t"
                                      + clazz.getConstantPoolInfos().get(localVariable.getNameIndex() - 1).getString()
                                      + "\t"
                                      + clazz.getConstantPoolInfos().get(localVariable.getDescriptorIndex() - 1).getString());
                        }
                    }
                }
            }

            if (attributes.get(i) instanceof Exceptions) {
                Exceptions exceptions = (Exceptions) attributes.get(i);
                sb.append("\n  Exceptions:\n   throws ");

                for (int j = 0; j < exceptions.getExceptionIndexTable().size(); j++) {
                    if (j != 0) {
                        sb.append(",");
                    }

                    sb.append(exceptions.getExceptionIndexTable().get(j).getString());
                }
            }

            if (attributes.get(i) instanceof Deprecated) {
                sb.append("\n\n  Deprecated: true");
            }

            if (attributes.get(i) instanceof RuntimeVisibleAnnotations) {
                RuntimeVisibleAnnotations runtimeVisibleAnnotations = (RuntimeVisibleAnnotations) attributes.get(i);
                sb.append("\n  RuntimeVisibleAnnotations: length = " + runtimeVisibleAnnotations.getLength());
                for (int j = 0; j < runtimeVisibleAnnotations.getAnnotations().size(); j++) {
                    sb.append("\n   " + runtimeVisibleAnnotations.getAnnotations().get(j));
                }
            }

            if (attributes.get(i) instanceof RuntimeInvisibleAnnocations) {
                RuntimeInvisibleAnnocations runtimeInvisibleAnnotations = (RuntimeInvisibleAnnocations) attributes.get(i);
                sb.append("\n  RuntimeInvisibleAnnocations: length = " + runtimeInvisibleAnnotations.getLength());
                for (int j = 0; j < runtimeInvisibleAnnotations.getAnnotations().size(); j++) {
                    sb.append("\n   " + runtimeInvisibleAnnotations.getAnnotations().get(j));
                }
            }

            if (attributes.get(i) instanceof AnnotationDefault) {
                AnnotationDefault annotationDefault = (AnnotationDefault) attributes.get(i);
                sb.append("\n  AnnotationDefault: length = " + annotationDefault.getLength());
                sb.append("\n   " + annotationDefault);
            }
        }

        return sb.append("\n").toString();
    }
}
