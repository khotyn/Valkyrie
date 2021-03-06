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
 * The attribute InnerClasses
 * 
 * @author khotyn
 */
public class InnerClasses extends Attribute {

    public static ConstantUTF8 name = INNER_CLASSES;
    private List<InnerClass>   innerClasses;

    public List<InnerClass> getInnerClasses() {
        return innerClasses;
    }

    public void setInnerClasses(List<InnerClass> innerClasses) {
        this.innerClasses = innerClasses;
    }
}
