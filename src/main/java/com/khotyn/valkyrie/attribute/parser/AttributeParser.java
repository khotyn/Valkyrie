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

    private Clazz    clazz;

    protected Cursor cursor;

    // private int
    public AttributeParser(Clazz clazz, Cursor cursor) {
        this.clazz = clazz;
        this.cursor = cursor;
    }

    /**
     * Parser the String into an attribute
     * 
     * @param str the String to parse
     * @return the corresponding attribute
     */
    public abstract Attribute parse() throws Exception;

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

}
