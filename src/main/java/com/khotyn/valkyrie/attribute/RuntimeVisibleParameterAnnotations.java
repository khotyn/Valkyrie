package com.khotyn.valkyrie.attribute;

import java.util.List;

public class RuntimeVisibleParameterAnnotations extends Attribute {

    protected String                  name = RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS;
    private List<ParameterAnnotation> parameterAnnotations;

    public List<ParameterAnnotation> getParameterAnnotations() {
        return parameterAnnotations;
    }

    public void setParameterAnnotations(List<ParameterAnnotation> parameterAnnotations) {
        this.parameterAnnotations = parameterAnnotations;
    }
}
