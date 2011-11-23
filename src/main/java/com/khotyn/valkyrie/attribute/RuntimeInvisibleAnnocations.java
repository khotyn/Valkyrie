package com.khotyn.valkyrie.attribute;

import java.util.List;

import com.khotyn.valkyrie.constant.ConstantUTF8;

public class RuntimeInvisibleAnnocations extends Attribute {

    public static ConstantUTF8 name = RUNTIME_INVISIBLE_ANNOTATIONS;

    private List<Annotation>   annotations;

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
}
