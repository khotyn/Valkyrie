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
import com.khotyn.valkyrie.Cursor;
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
     * @param cursor
     */
    public LineNumberTableParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() {
        LineNumberTable result = new LineNumberTable();
        result.setLength(getCursor().u4());
        int lineNumberTableLength = getCursor().u2();
        List<LineNumber> lineNumberTable = new ArrayList<LineNumber>(lineNumberTableLength);

        for (int i = 0; i < lineNumberTableLength; i++) {
            LineNumber lineNumber = new LineNumber();
            lineNumber.setStartPC(getCursor().u2());
            lineNumber.setLineNumber(getCursor().u2());
            lineNumberTable.add(lineNumber);
        }

        return result;
    }
}
