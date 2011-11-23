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

import com.khotyn.valkyrie.constant.ConstantUTF8;

/**
 * Attribute ConstantValue
 * 
 * @author khotyn
 */
public class ConstantValue extends Attribute {

    public static ConstantUTF8 name   = CONSTANT_VALUE;
    protected int              length = 2;
    private int                constantValueIndex;

    public int getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(int constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

}
