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

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.AnnotationDefault;
import com.khotyn.valkyrie.attribute.Attribute;

/**
 * Parser to parse {@link AnnotationDefault}
 * 
 * @author khotyn
 * 
 */
public class AnnotationDefaultParser extends AttributeParser {
    private AnnotationParser annotationParser = new AnnotationParser(getCursor());

    /**
     * @param clazz
     * @param cursor
     */
    public AnnotationDefaultParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() throws Exception {
        AnnotationDefault annotationDefault = new AnnotationDefault();
        annotationDefault.setLength(getCursor().u4());
        annotationDefault.setDefaultValue(annotationParser.getElementValueParser().parse());
        return annotationDefault;
    }

}
