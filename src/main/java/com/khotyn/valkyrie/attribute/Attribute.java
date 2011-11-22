package com.khotyn.valkyrie.attribute;

/**
 * Representing an attribute
 * 
 * @author khotyn 2011-11-17 ÏÂÎç5:17:13
 */
public class Attribute {
    // Names of all predefined attributes.
    public static final String CONSTANT_VALUE                          = "ConstantValue";
    public static final String CODE                                    = "Code";
    public static final String STACK_MAP_TABLE                         = "StackMapTrace";
    public static final String EXCEPTIONS                              = "Exceptions";
    public static final String INNER_CLASSES                           = "InnerClasses";
    public static final String ENCLOSING_METHOD                        = "EnclosingMethod";
    public static final String SYNTHETIC                               = "Synthetic";
    public static final String SIGNATURE                               = "Signature";
    public static final String SOURCE_FILE                             = "SourceFile";
    public static final String SOURCE_DEBUG_EXTENSION                  = "SourceDebugExtension";
    public static final String LINE_NUMBER_TABLE                       = "LineNumberTable";
    public static final String LOCAL_VARIABLE_TABLE                    = "LocalVariableTable";
    public static final String LOCAL_VARIABLE_TYPE_TABLE               = "LocalVariableTypeTable";
    public static final String DEPRECATED                              = "Deprecated";
    public static final String RUNTIME_VISIBLE_ANNOTATIONS             = "RuntimeVisibleAnnotations";
    public static final String RUNTIME_INVISIBLE_ANNOTATIONS           = "RuntimeInvisibileAnnotations";
    public static final String RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS   = "RuntimeVisibleParameterAnnotations";
    public static final String RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
    public static final String ANNOTAION_DEFAULT                       = "AnnotationDefault";
    public static final String BOOTSTRAP_METHODS                       = "BootstrapMethods";

    protected String           name;
    protected int              length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
