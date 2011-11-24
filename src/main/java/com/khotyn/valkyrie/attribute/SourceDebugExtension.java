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
 * {@link Attribute} SourceDebugExtension
 * 
 * @author khotyn
 */
public class SourceDebugExtension extends Attribute {

    public static ConstantUTF8 name = SOURCE_DEBUG_EXTENSION;
    private String             debugExtension;

    public String getDebugExtension() {
        return debugExtension;
    }

    public void setDebugExtension(String debugExtension) {
        this.debugExtension = debugExtension;
    }

}
