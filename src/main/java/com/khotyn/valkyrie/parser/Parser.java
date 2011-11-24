/**
 * Project: Valkyrie
 * 
 * File Created at Nov 24, 2011
 * $Id$
 * 
 * This is some code written by khotyn, and you are free to distribute those code for any use.
 * Welcome to my website: http://khotyn.com
 * Free we will be!
 */
package com.khotyn.valkyrie.parser;

/**
 * The inteface of parser
 * 
 * @author khotyn
 * 
 */
public interface Parser {
    public int getCursor();

    public void setCursor(int cursor);

    public String getBytecodeString();

    public void setBytecodeString(String bytecodeString);

    public void reset();
}
