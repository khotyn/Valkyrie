package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.Synthetic;

/**
 * The parser to parse {@link Synthetic}
 * 
 * @author khotyn 2011-11-23 下午3:29:39
 */
public class SyntheticParser extends AttributeParser {

    public SyntheticParser(Clazz clazz) {
        super(clazz);
    }

    @Override
    public Attribute parse(String str) {
        return new Synthetic();
    }

}
