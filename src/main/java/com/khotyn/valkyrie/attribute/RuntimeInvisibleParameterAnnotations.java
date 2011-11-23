package com.khotyn.valkyrie.attribute;

import java.util.List;

public class RuntimeInvisibleParameterAnnotations extends Attribute {

    protected String                  name = RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS;
    private List<ParameterAnnotation> parameterAnnotations;

    public List<ParameterAnnotation> getParameterAnnotations() {
        return parameterAnnotations;
    }

    public void setParameterAnnotations(List<ParameterAnnotation> parameterAnnotations) {
        this.parameterAnnotations = parameterAnnotations;
    }
}
