package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.Deprecated;

/**
 * The parser to parse {@link Deprecated}
 * 
 * @author khotyn 2011-11-23 下午3:31:22
 */
public class DeprecatedParser extends AttributeParser {

    public DeprecatedParser(Clazz clazz) {
        super(clazz);
    }

    @Override
    public Attribute parse() {
        return new Deprecated();
    }

}
