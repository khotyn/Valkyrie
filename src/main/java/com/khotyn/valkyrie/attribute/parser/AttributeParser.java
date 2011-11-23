package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.attribute.Attribute;

/**
 * An attribute parser to parse attribute
 * 
 * @author khotyn 2011-11-23 下午3:27:28
 */
public interface AttributeParser {

    /**
     * Parser the String into an attribute
     * 
     * @param str the String to parse
     * @return the corresponding attribute
     */
    public Attribute parse(String str);
}
