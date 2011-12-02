package com.khotyn.valkyrie.attribute;

import com.khotyn.valkyrie.constant.ConstantUTF8;

/**
 * Representing an attribute
 * 
 * @author khotyn 2011-11-17 PM 5:17:13
 */
public abstract class Attribute {

    // Names of all predefined attributes.
    public static final ConstantUTF8 CONSTANT_VALUE                          = new ConstantUTF8("ConstantValue");
    public static final ConstantUTF8 CODE                                    = new ConstantUTF8("Code");
    public static final ConstantUTF8 STACK_MAP_TABLE                         = new ConstantUTF8("StackMapTrace");
    public static final ConstantUTF8 EXCEPTIONS                              = new ConstantUTF8("Exceptions");
    public static final ConstantUTF8 INNER_CLASSES                           = new ConstantUTF8("InnerClasses");
    public static final ConstantUTF8 ENCLOSING_METHOD                        = new ConstantUTF8("EnclosingMethod");
    public static final ConstantUTF8 SYNTHETIC                               = new ConstantUTF8("Synthetic");
    public static final ConstantUTF8 SIGNATURE                               = new ConstantUTF8("Signature");
    public static final ConstantUTF8 SOURCE_FILE                             = new ConstantUTF8("SourceFile");
    public static final ConstantUTF8 SOURCE_DEBUG_EXTENSION                  = new ConstantUTF8("SourceDebugExtension");
    public static final ConstantUTF8 LINE_NUMBER_TABLE                       = new ConstantUTF8("LineNumberTable");
    public static final ConstantUTF8 LOCAL_VARIABLE_TABLE                    = new ConstantUTF8("LocalVariableTable");
    public static final ConstantUTF8 LOCAL_VARIABLE_TYPE_TABLE               = new ConstantUTF8(
                                                                                                "LocalVariableTypeTable");
    public static final ConstantUTF8 DEPRECATED                              = new ConstantUTF8("Deprecated");
    public static final ConstantUTF8 RUNTIME_VISIBLE_ANNOTATIONS             = new ConstantUTF8(
                                                                                                "RuntimeVisibleAnnotations");
    public static final ConstantUTF8 RUNTIME_INVISIBLE_ANNOTATIONS           = new ConstantUTF8(
                                                                                                "RuntimeInvisibleAnnotations");
    public static final ConstantUTF8 RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS   = new ConstantUTF8(
                                                                                                "RuntimeVisibleParameterAnnotations");
    public static final ConstantUTF8 RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = new ConstantUTF8(
                                                                                                "RuntimeInvisibleParameterAnnotations");
    public static final ConstantUTF8 ANNOTAION_DEFAULT                       = new ConstantUTF8("AnnotationDefault");
    public static final ConstantUTF8 BOOTSTRAP_METHODS                       = new ConstantUTF8("BootstrapMethods");

    protected static ConstantUTF8    name;
    protected int                    length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
