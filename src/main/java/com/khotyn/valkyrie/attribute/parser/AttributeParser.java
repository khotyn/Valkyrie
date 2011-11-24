package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.ClazzAware;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.parser.Parser;

/**
 * An attribute parser to parse attribute
 * 
 * @author khotyn 2011-11-23 下午3:27:28
 */
public abstract class AttributeParser implements ClazzAware, Parser<Attribute> {

    private Clazz  clazz;

    private Cursor cursor;

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    // private int
    public AttributeParser(Clazz clazz) {
        this.clazz = clazz;
    }

    /**
     * Parser the String into an attribute
     * 
     * @param str the String to parse
     * @return the corresponding attribute
     */
    public abstract Attribute parse();

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

}
