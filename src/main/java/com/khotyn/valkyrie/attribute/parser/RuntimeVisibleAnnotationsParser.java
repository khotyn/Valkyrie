/**
 * Project: Valkyrie
 * 
 * File Created at Nov 24, 2011
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
import com.khotyn.valkyrie.attribute.Annotation;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.RuntimeVisibleAnnotations;

/**
 * Parser to parse {@link RuntimeVisibleAnnotations}
 * 
 * @author khotyn
 * 
 */
public class RuntimeVisibleAnnotationsParser extends AttributeParser {

    /**
     * @param clazz
     */
    public RuntimeVisibleAnnotationsParser(Clazz clazz) {
        super(clazz);
    }

    @Override
    public Attribute parse(String str) {
        RuntimeVisibleAnnotations result = new RuntimeVisibleAnnotations();
        result.setLength(str.length() / 2);
        int cursor = 0;
        int numberOfAnnotations = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
        List<Annotation> annotations = new ArrayList<Annotation>(numberOfAnnotations);

        for (int i = 0; i < numberOfAnnotations; i++) {
            // annotations.add(AnnotationParser.parse())
        }

        return result;
    }
}
