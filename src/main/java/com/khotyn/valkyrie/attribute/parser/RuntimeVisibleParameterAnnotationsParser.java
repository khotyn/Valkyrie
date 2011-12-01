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
import com.khotyn.valkyrie.attribute.ParameterAnnotation;
import com.khotyn.valkyrie.attribute.RuntimeVisibleParameterAnnotations;

/**
 * Parser to parse {@link RuntimeVisibleParameterAnnotations}
 * 
 * @author khotyn
 */
public class RuntimeVisibleParameterAnnotationsParser extends AttributeParser {

    private AnnotationParser annotationParser = new AnnotationParser(getCursor());

    /**
     * @param clazz
     * @param cursor
     */
    public RuntimeVisibleParameterAnnotationsParser(Clazz clazz, Cursor cursor){
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() throws Exception {
        RuntimeVisibleParameterAnnotations result = new RuntimeVisibleParameterAnnotations();
        result.setLength(getCursor().u4());
        int numberOfParameters = getCursor().u1();
        List<ParameterAnnotation> params = new ArrayList<ParameterAnnotation>();

        for (int i = 0; i < numberOfParameters; i++) {
            ParameterAnnotation paramAnnotation = new ParameterAnnotation();
            int numberOfAnnotations = getCursor().u2();
            List<Annotation> annotations = new ArrayList<Annotation>();

            for (int j = 0; j < numberOfAnnotations; j++) {
                annotations.add(annotationParser.parse());
            }

            paramAnnotation.setAnnotations(annotations);
            params.add(paramAnnotation);
        }

        result.setParameterAnnotations(params);

        return result;
    }
}
