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

import java.util.List;

import com.khotyn.valkyrie.constant.ConstantUTF8;

/**
 * @author khotyn
 */
public class StackMapTable extends Attribute {

    public static ConstantUTF8  name = STACK_MAP_TABLE;
    private List<StackMapFrame> entries;

    public List<StackMapFrame> getEntries() {
        return entries;
    }

    public void setEntries(List<StackMapFrame> entries) {
        this.entries = entries;
    }
}
