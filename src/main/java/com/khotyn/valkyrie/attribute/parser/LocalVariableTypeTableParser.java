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
import com.khotyn.valkyrie.attribute.LocalVariableType;
import com.khotyn.valkyrie.attribute.LocalVariableTypeTable;

/**
 * Parser to parse {@link LocalVariableTypeTable}
 * 
 * @author khotyn
 * 
 */
public class LocalVariableTypeTableParser extends AttributeParser {

    /**
     * @param clazz
     * @param cursor
     */
    public LocalVariableTypeTableParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() {
        LocalVariableTypeTable result = new LocalVariableTypeTable();
        result.setLength(getCursor().u4());
        int tableLength = getCursor().u2();
        List<LocalVariableType> localVariableTypes = new ArrayList<LocalVariableType>(tableLength);

        for (int i = 0; i < tableLength; i++) {
            LocalVariableType localVariableType = new LocalVariableType();
            localVariableType.setStartPC(getCursor().u2());
            localVariableType.setLength(getCursor().u2());
            localVariableType.setNameIndex(getCursor().u2());
            localVariableType.setSignatureIndex(getCursor().u2());
            localVariableType.setIndex(getCursor().u2());
            localVariableTypes.add(localVariableType);
        }

        result.setLocalVariableType(localVariableTypes);

        return result;
    }
}
