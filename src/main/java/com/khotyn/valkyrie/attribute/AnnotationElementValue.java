package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.TypeTags;

public class AnnotationElementValue extends ElementValue {

    public static List<TypeTags> tags;
    static {
        List<TypeTags> tags = new ArrayList<TypeTags>();
        tags.add(TypeTags.ANNOTATION);
        AnnotationElementValue.tags = tags;
    }

    private Annotation           annotation;

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }
}
