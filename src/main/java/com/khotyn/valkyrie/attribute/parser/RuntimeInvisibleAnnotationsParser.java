/**
 * Project: Valkyrie
 * 
 * File Created at Nov 26, 2011
 * $Id$
 * 
 * This is some code written by khotyn, and you are free to distribute those code for any use.
 * Welcome to my website: http://khotyn.com
 * Free we will be!
 */
package com.khotyn.valkyrie.attribute.parser;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.Annotation;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.RuntimeInvisibleAnnocations;

/**
 * Parser to parse {@link RuntimeInvisibleAnnocations}
 * 
 * @author khotyn
 * 
 */
public class RuntimeInvisibleAnnotationsParser extends AttributeParser {
    private AnnotationParser annotationParser = new AnnotationParser(getCursor());

    /**
     * @param clazz
     * @param cursor
     */
    public RuntimeInvisibleAnnotationsParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() throws Exception {
        RuntimeInvisibleAnnocations result = new RuntimeInvisibleAnnocations();
        result.setLength(getCursor().u4());
        int numberOfAnnotations = getCursor().u2();
        List<Annotation> annotations = new ArrayList<Annotation>(numberOfAnnotations);

        for (int i = 0; i < numberOfAnnotations; i++) {
            annotations.add(annotationParser.parse());
        }

        result.setAnnotations(annotations);
        return result;
    }
}
