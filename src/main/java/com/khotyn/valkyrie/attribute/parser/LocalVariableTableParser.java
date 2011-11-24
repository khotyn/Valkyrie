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
import com.khotyn.valkyrie.attribute.LocalVariable;
import com.khotyn.valkyrie.attribute.LocalVariableTable;

/**
 * Parser to parse {@link LocalVariable}
 * 
 * @author khotyn
 * 
 */
public class LocalVariableTableParser extends AttributeParser {

    /**
     * @param clazz
     */
    public LocalVariableTableParser(Clazz clazz) {
        super(clazz);
    }

    @Override
    public Attribute parse() {
        LocalVariableTable result = new LocalVariableTable();
        result.setLength(getCursor().u4());
        int tableLength = getCursor().u2();
        List<LocalVariable> localVariables = new ArrayList<LocalVariable>(tableLength);

        for (int i = 0; i < tableLength; i++) {
            LocalVariable localVariable = new LocalVariable();
            localVariable.setStartPC(getCursor().u2());
            localVariable.setLength(getCursor().u2());
            localVariable.setNameIndex(getCursor().u2());
            localVariable.setDescriptorIndex(getCursor().u2());
            localVariable.setIndex(getCursor().u2());
            localVariables.add(localVariable);
        }

        result.setLocalVariableTable(localVariables);

        return result;
    }

}
