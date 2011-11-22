/**
 * Project: Valkyrie
 * 
 * File Created at Nov 22, 2011
 * $Id$
 * 
 * This is some code written by khotyn, and you are free to distribute those code for any use.
 * Welcome to my website: http://khotyn.com
 * Free we will be!
 */
package com.khotyn.valkyrie.attribute;

/**
 * Attribute ConstantValue
 * 
 * @author khotyn
 * 
 */
public class ConstantValue extends Attribute {

    protected String name   = CONSTANT_VALUE;
    protected int    length = 2;
    private int      index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
