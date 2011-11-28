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

import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.Annotation;
import com.khotyn.valkyrie.attribute.ElementValuePair;
import com.khotyn.valkyrie.parser.Parser;

/**
 * Parser to parse {@link Annotation}
 * 
 * @author khotyn
 * 
 */
public class AnnotationParser implements Parser<Annotation> {
    private Cursor             cursor;
    private ElementValueParser elementValueParser;

    public AnnotationParser(Cursor cursor) {
        this.cursor = cursor;
        elementValueParser = new ElementValueParser(cursor, this);
    }

    public Annotation parse() throws Exception {
        Annotation result = new Annotation();
        result.setTypeIndex(cursor.u2());
        int numberOfElementValuePair = cursor.u2();
        List<ElementValuePair> elementValuePairs = new ArrayList<ElementValuePair>(numberOfElementValuePair);
        for (int i = 0; i < numberOfElementValuePair; i++) {
            ElementValuePair elementValuePair = new ElementValuePair();
            elementValuePair.setNameIndex(cursor.u2());
            elementValuePair.setValue(elementValueParser.parse());
            elementValuePairs.add(elementValuePair);
        }
        result.setElementValuePairs(elementValuePairs);
        return result;
    }

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;

    }

    public ElementValueParser getElementValueParser() {
        return elementValueParser;
    }
}
