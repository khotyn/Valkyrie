package com.khotyn.valkyrie.attribute;

import java.util.List;

import com.khotyn.valkyrie.constant.ConstantUTF8;

public class RuntimeInvisibleParameterAnnotations extends Attribute {

    public static ConstantUTF8        name = RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS;
    private List<ParameterAnnotation> parameterAnnotations;

    public List<ParameterAnnotation> getParameterAnnotations() {
        return parameterAnnotations;
    }

    public void setParameterAnnotations(List<ParameterAnnotation> parameterAnnotations) {
        this.parameterAnnotations = parameterAnnotations;
    }
}
