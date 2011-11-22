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

/**
 * {@link Attribute} SourceDebugExtension
 * 
 * @author khotyn
 * 
 */
public class SourceDebugExtension extends Attribute {
    protected String     name = SOURCE_DEBUG_EXTENSION;
    private List<String> debugExtension;

    public List<String> getDebugExtension() {
        return debugExtension;
    }

    public void setDebugExtension(List<String> debugExtension) {
        this.debugExtension = debugExtension;
    }
}
