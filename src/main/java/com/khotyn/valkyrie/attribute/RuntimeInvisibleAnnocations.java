package com.khotyn.valkyrie.attribute;

import java.util.List;

public class RuntimeInvisibleAnnocations extends Attribute {

    protected String         name = RUNTIME_INVISIBLE_ANNOTATIONS;

    private List<Annotation> annotations;

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
}
