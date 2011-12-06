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

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.EnclosingMethod;

/**
 * Parser to parse {@link EnclosingMethod}
 * 
 * @author khotyn
 */
public class EnclosingMethodParser extends AttributeParser {

    /**
     * @param clazz
     * @param cursor
     */
    public EnclosingMethodParser(Clazz clazz, Cursor cursor){
        super(clazz, cursor);
    }

    /*
     * (non-Javadoc)
     * @see com.khotyn.valkyrie.attribute.parser.AttributeParser#parse(java.lang.String)
     */
    @Override
    public Attribute parse() {
        EnclosingMethod result = new EnclosingMethod();
        result.setLength(getCursor().u4());
        result.setClassIndex(getCursor().u2());
        result.setMethodIndex(getCursor().u2());
        return result;
    }

}
