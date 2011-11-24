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
import com.khotyn.valkyrie.TypeTags;
import com.khotyn.valkyrie.attribute.Annotation;
import com.khotyn.valkyrie.attribute.AnnotationElementValue;
import com.khotyn.valkyrie.attribute.ArrayElementValue;
import com.khotyn.valkyrie.attribute.ClassInfoElementValue;
import com.khotyn.valkyrie.attribute.ConstElementValue;
import com.khotyn.valkyrie.attribute.ElementValue;
import com.khotyn.valkyrie.attribute.ElementValuePair;
import com.khotyn.valkyrie.attribute.EnumConstElementValue;

/**
 * Parser to parse {@link Annotation}
 * 
 * @author khotyn
 * 
 */
public class AnnotationParser {
    private static String unconsumedString = "";

    public static Annotation parse(String str) {
        unconsumedString = "";
        Annotation result = new Annotation();
        int cursor = 0;
        result.setTypeIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
        int numberOfElementValuePair = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
        List<ElementValuePair> elementValuePairs = new ArrayList<ElementValuePair>(numberOfElementValuePair);
        for (int i = 0; i < numberOfElementValuePair; i++) {
            ElementValuePair elementValuePair = new ElementValuePair();
            elementValuePair.setNameIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            elementValuePair.setValue(parseElementValue(str.substring(cursor)));
            elementValuePairs.add(elementValuePair);
        }
        result.setElementValuePairs(elementValuePairs);
        return result;
    }

    private static ElementValue parseElementValue(String str) {
        int cursor = 0;
        char tag = (char) Integer.parseInt(str.substring(cursor, cursor += Clazz.U1), 16);
        ElementValue elementValue = null;
        if (ConstElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            ConstElementValue constElementValue = new ConstElementValue();
            constElementValue.setConstValueIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            elementValue = constElementValue;
        } else if (EnumConstElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            EnumConstElementValue enumConstElementValue = new EnumConstElementValue();
            enumConstElementValue.setTypeNameIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            enumConstElementValue.setConstNameIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            elementValue = enumConstElementValue;
        } else if (ClassInfoElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            ClassInfoElementValue classInfoElementValue = new ClassInfoElementValue();
            classInfoElementValue.setClassInfoIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            elementValue = classInfoElementValue;
        } else if (AnnotationElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            AnnotationElementValue annotationElementValue = new AnnotationElementValue();
            annotationElementValue.setAnnotation(AnnotationParser.parse(str.substring(cursor, str.length() - cursor)));
            elementValue = annotationElementValue;
        } else if (ArrayElementValue.tags.contains(TypeTags.getTypeTags(tag))) {
            ArrayElementValue arrayElementValue = new ArrayElementValue();
            int arrayLength = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
            List<ElementValue> values = new ArrayList<ElementValue>(arrayLength);
            unconsumedString = str.substring(cursor);
            for (int i = 0; i < arrayLength; i++) {
                values.add(parseElementValue(unconsumedString));
            }
            arrayElementValue.setValues(values);
            elementValue = arrayElementValue;
        }
        unconsumedString = str.substring(cursor);
        return elementValue;
    }
}
