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

import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.TypeTags;
import com.khotyn.valkyrie.attribute.AnnotationElementValue;
import com.khotyn.valkyrie.attribute.ArrayElementValue;
import com.khotyn.valkyrie.attribute.ClassInfoElementValue;
import com.khotyn.valkyrie.attribute.ConstElementValue;
import com.khotyn.valkyrie.attribute.ElementValue;
import com.khotyn.valkyrie.attribute.EnumConstElementValue;
import com.khotyn.valkyrie.parser.Parser;

/**
 * Parser to parse {@link ElementValue}
 * 
 * @author khotyn
 * 
 */
public class ElementValueParser implements Parser<ElementValue> {
    private AnnotationParser annotationParser;
    private Cursor           cursor;

    public ElementValueParser(Cursor cursor, AnnotationParser annotationParser) {
        this.cursor = cursor;
        this.annotationParser = annotationParser;
    }

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public ElementValue parse() throws Exception {
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
            annotationElementValue.setAnnotation(annotationParser.parse());
            elementValue = annotationElementValue;
        } else if (ArrayElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            ArrayElementValue arrayElementValue = new ArrayElementValue();
            int arrayLength = cursor.u2();
            List<ElementValue> values = new ArrayList<ElementValue>(arrayLength);
            for (int i = 0; i < arrayLength; i++) {
                values.add(parse());
            }
            arrayElementValue.setValues(values);
            elementValue = arrayElementValue;
        }
        return elementValue;
    }
}
