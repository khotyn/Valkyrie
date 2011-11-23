package com.khotyn.valkyrie.attribute;

import java.util.List;

import com.khotyn.valkyrie.constant.ConstantUTF8;

public class RuntimeVisibleParameterAnnotations extends Attribute {

    public static ConstantUTF8        name = RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS;
    private List<ParameterAnnotation> parameterAnnotations;

    public List<ParameterAnnotation> getParameterAnnotations() {
        return parameterAnnotations;
    }

    public void setParameterAnnotations(List<ParameterAnnotation> parameterAnnotations) {
        this.parameterAnnotations = parameterAnnotations;
    }
}
