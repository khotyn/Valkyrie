package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.Deprecated;

/**
 * The parser to parse {@link Deprecated}
 * 
 * @author khotyn 2011-11-23 下午3:31:22
 */
public class DeprecatedParser implements AttributeParser {

    @Override
    public Attribute parse(String str) {
        return new Deprecated();
    }

}
