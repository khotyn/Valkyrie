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
import com.khotyn.valkyrie.TypeTags;
import com.khotyn.valkyrie.attribute.Annotation;
import com.khotyn.valkyrie.attribute.AnnotationElementValue;
import com.khotyn.valkyrie.attribute.ArrayElementValue;
import com.khotyn.valkyrie.attribute.ClassInfoElementValue;
import com.khotyn.valkyrie.attribute.ConstElementValue;
import com.khotyn.valkyrie.attribute.ElementValue;
import com.khotyn.valkyrie.attribute.ElementValuePair;
import com.khotyn.valkyrie.attribute.EnumConstElementValue;
import com.khotyn.valkyrie.parser.Parser;

/**
 * Parser to parse {@link Annotation}
 * 
 * @author khotyn
 * 
 */
public class AnnotationParser implements Parser<Annotation> {
    private Cursor cursor;

    public AnnotationParser(Cursor cursor) {
        this.cursor = cursor;
    }

    public Annotation parse() {
        Annotation result = new Annotation();
        result.setTypeIndex(cursor.u2());
        int numberOfElementValuePair = cursor.u2();
        List<ElementValuePair> elementValuePairs = new ArrayList<ElementValuePair>(numberOfElementValuePair);
        for (int i = 0; i < numberOfElementValuePair; i++) {
            ElementValuePair elementValuePair = new ElementValuePair();
            elementValuePair.setNameIndex(cursor.u2());
            elementValuePair.setValue(parseElementValue());
            elementValuePairs.add(elementValuePair);
        }
        result.setElementValuePairs(elementValuePairs);
        return result;
    }

    private ElementValue parseElementValue() {
        char tag = (char) cursor.u1();
        ElementValue elementValue = null;
        if (ConstElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            ConstElementValue constElementValue = new ConstElementValue();
            constElementValue.setConstValueIndex(cursor.u2());
            elementValue = constElementValue;
        } else if (EnumConstElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            EnumConstElementValue enumConstElementValue = new EnumConstElementValue();
            enumConstElementValue.setTypeNameIndex(cursor.u2());
            enumConstElementValue.setConstNameIndex(cursor.u2());
            elementValue = enumConstElementValue;
        } else if (ClassInfoElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            ClassInfoElementValue classInfoElementValue = new ClassInfoElementValue();
            classInfoElementValue.setClassInfoIndex(cursor.u2());
            elementValue = classInfoElementValue;
        } else if (AnnotationElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            AnnotationElementValue annotationElementValue = new AnnotationElementValue();
            annotationElementValue.setAnnotation(parse());
            elementValue = annotationElementValue;
        } else if (ArrayElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            ArrayElementValue arrayElementValue = new ArrayElementValue();
            int arrayLength = cursor.u2();
            List<ElementValue> values = new ArrayList<ElementValue>(arrayLength);
            for (int i = 0; i < arrayLength; i++) {
                values.add(parseElementValue());
            }
            arrayElementValue.setValues(values);
            elementValue = arrayElementValue;
        }
        return elementValue;
    }

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;

    }
}
