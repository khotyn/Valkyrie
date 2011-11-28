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
import com.khotyn.valkyrie.attribute.SourceDebugExtension;
import com.khotyn.valkyrie.util.ValkyrieUtil;

/**
 * Parser to parse {@link SourceDebugExtension}
 * 
 * @author khotyn
 * 
 */
public class SourceDebugExtensionParser extends AttributeParser {

    /**
     * @param clazz
     * @param cursor
     */
    public SourceDebugExtensionParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Attribute parse() {
        SourceDebugExtension result = new SourceDebugExtension();
        int length = getCursor().u4();
        result.setLength(length);
        result.setDebugExtension(ValkyrieUtil.hexStringToASCIIString(getCursor().getSubStr(length * 2)));
        return result;
    }
}
