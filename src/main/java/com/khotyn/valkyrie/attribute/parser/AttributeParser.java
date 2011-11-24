package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.ClazzAware;
import com.khotyn.valkyrie.attribute.Attribute;

/**
 * An attribute parser to parse attribute
 * 
 * @author khotyn 2011-11-23 下午3:27:28
 */
public abstract class AttributeParser implements ClazzAware {

    private Clazz clazz;

    public AttributeParser(Clazz clazz){
        this.clazz = clazz;
    }

    /**
     * Parser the String into an attribute
     * 
     * @param str the String to parse
     * @return the corresponding attribute
     */
    public abstract Attribute parse(String str);

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
