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
     */
    public LocalVariableTypeTableParser(Clazz clazz) {
        super(clazz);
    }

    @Override
    public Attribute parse(String str) {
        LocalVariableTypeTable result = new LocalVariableTypeTable();
        result.setLength(str.length() / 2);
        int cursor = 0;
        int tableLength = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
        List<LocalVariableType> localVariableTypes = new ArrayList<LocalVariableType>(tableLength);

        for (int i = 0; i < tableLength; i++) {
            LocalVariableType localVariableType = new LocalVariableType();
            localVariableType.setStartPC(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            localVariableType.setLength(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            localVariableType.setNameIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            localVariableType.setSignatureIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            localVariableType.setIndex(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            localVariableTypes.add(localVariableType);
        }

        result.setLocalVariableType(localVariableTypes);

        return result;
    }
}
