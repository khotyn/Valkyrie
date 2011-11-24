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
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.LineNumber;
import com.khotyn.valkyrie.attribute.LineNumberTable;

/**
 * Parser to parse {@link LineNumberTable}
 * 
 * @author khotyn
 * 
 */
public class LineNumberTableParser extends AttributeParser {

    /**
     * @param clazz
     */
    public LineNumberTableParser(Clazz clazz) {
        super(clazz);
    }

    @Override
    public Attribute parse(String str) {
        LineNumberTable result = new LineNumberTable();
        int cursor = 0;
        result.setLength(str.length() / 2);
        int lineNumberTableLength = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
        List<LineNumber> lineNumberTable = new ArrayList<LineNumber>(lineNumberTableLength);

        for (int i = 0; i < lineNumberTableLength; i++) {
            LineNumber lineNumber = new LineNumber();
            lineNumber.setStartPC(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            lineNumber.setLineNumber(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            lineNumberTable.add(lineNumber);
        }

        return result;
    }
}
