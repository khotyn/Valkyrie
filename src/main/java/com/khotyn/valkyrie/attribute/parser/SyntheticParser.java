package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.Synthetic;

/**
 * The parser to parse {@link Synthetic}
 * 
 * @author khotyn 2011-11-23 下午3:29:39
 */
public class SyntheticParser extends AttributeParser {

    /**
     * @param clazz
     * @param cursor
     */
    public SyntheticParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() {
        return new Synthetic();
    }

}
