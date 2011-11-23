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
 * Attribute SourceFile
 * 
 * @author khotyn
 */
public class SourceFile extends Attribute {

    public static ConstantUTF8 name   = SOURCE_FILE;
    protected int              length = 4;
    private int                sourcefileIndex;

    public int getSourcefileIndex() {
        return sourcefileIndex;
    }

    public void setSourcefileIndex(int sourcefileIndex) {
        this.sourcefileIndex = sourcefileIndex;
    }
}
