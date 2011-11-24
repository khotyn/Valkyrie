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
import com.khotyn.valkyrie.attribute.Exceptions;
import com.khotyn.valkyrie.constant.ConstantClass;

/**
 * Parser to parse {@link Exceptions}
 * 
 * @author khotyn
 * 
 */
public class ExceptionsParser extends AttributeParser {

    /**
     * @param clazz
     */
    public ExceptionsParser(Clazz clazz) {
        super(clazz);
    }

    /*
     * (non-Javadoc)
     * @see com.khotyn.valkyrie.attribute.parser.AttributeParser#parse(java.lang.String)
     */
    @Override
    public Attribute parse(String str) {
        Exceptions result = new Exceptions();
        int cursor = 0;
        result.setLength(str.length() / 2);
        int numberOfExceptions = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
        List<ConstantClass> exceptions = new ArrayList<ConstantClass>(numberOfExceptions);

        for (int i = 0; i < numberOfExceptions; i++) {
            int index = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16) - 1;
            exceptions.add((ConstantClass) getClazz().getConstantPoolInfos().get(index));
        }

        result.setExceptionIndexTable(exceptions);

        return result;
    }
}
