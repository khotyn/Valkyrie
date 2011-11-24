package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.ConstantValue;

/**
 * A parser to parse {@link ConstantValue}
 * 
 * @author khotyn 2011-11-23 下午4:52:16
 */
public class ConstantValueParser extends AttributeParser {

    public ConstantValueParser(Clazz clazz){
        super(clazz);
    }

    @Override
    public Attribute parse(String str) {
        ConstantValue constantValue = new ConstantValue();
        constantValue.setLength(str.length() / 2);
        constantValue.setConstantValueIndex(Integer.parseInt(str, 16));
        return constantValue;
    }
}
