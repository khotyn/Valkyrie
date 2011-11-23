package com.khotyn.valkyrie.attribute;

import java.util.List;

import com.khotyn.valkyrie.constant.ConstantUTF8;

/**
 * TODO: RuntimeVisibleAnnotation.java
 * 
 * @author khotyn 2011-11-23 上午10:30:04
 */
public class RuntimeVisibleAnnotation extends Attribute {

    public static ConstantUTF8 name = RUNTIME_VISIBLE_ANNOTATIONS;
    private List<Annotation>   annotations;

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
}
