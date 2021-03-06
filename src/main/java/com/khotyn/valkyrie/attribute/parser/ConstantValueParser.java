package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.ConstantValue;

/**
 * A parser to parse {@link ConstantValue}
 * 
 * @author khotyn 2011-11-23 下午4:52:16
 */
public class ConstantValueParser extends AttributeParser {

    public ConstantValueParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() {
        ConstantValue constantValue = new ConstantValue();
        constantValue.setLength(getCursor().u4());
        constantValue.setConstantValueIndex(getCursor().u2());
        return constantValue;
    }
}
