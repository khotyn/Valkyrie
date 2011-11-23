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

import com.khotyn.valkyrie.AccessFlags;

/**
 * Representing the information of inner class.
 * 
 * @author khotyn
 * 
 */
public class InnerClass {
    private int              innerClassInfo;
    private int              outerClassInfo;
    private int              innerName;
    private List<AccessFlags> innerClassAccessFlags;

    public int getInnerClassInfo() {
        return innerClassInfo;
    }

    public void setInnerClassInfo(int innerClassInfo) {
        this.innerClassInfo = innerClassInfo;
    }

    public int getOuterClassInfo() {
        return outerClassInfo;
    }

    public void setOuterClassInfo(int outerClassInfo) {
        this.outerClassInfo = outerClassInfo;
    }

    public int getInnerName() {
        return innerName;
    }

    public void setInnerName(int innerName) {
        this.innerName = innerName;
    }

    public List<AccessFlags> getInnerClassAccessFlags() {
        return innerClassAccessFlags;
    }

    public void setInnerClassAccessFlags(List<AccessFlags> innerClassAccessFlags) {
        this.innerClassAccessFlags = innerClassAccessFlags;
    }
}
