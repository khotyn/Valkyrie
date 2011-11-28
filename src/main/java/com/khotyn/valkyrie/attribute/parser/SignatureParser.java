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
import com.khotyn.valkyrie.attribute.Signature;

/**
 * Parser to parse {@link Signature}
 * 
 * @author khotyn
 * 
 */
public class SignatureParser extends AttributeParser {

    /**
     * @param clazz
     * @param cursor
     */
    public SignatureParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    /*
     * (non-Javadoc)
     * @see com.khotyn.valkyrie.attribute.parser.AttributeParser#parse(java.lang.String)
     */
    @Override
    public Attribute parse() {
        Signature result = new Signature();
        result.setSignatureIndex(getCursor().u2());
        return result;
    }
}
