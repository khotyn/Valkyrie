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

import com.khotyn.valkyrie.Cursor;

/**
 * The inteface of parser
 * 
 * @author khotyn
 * 
 */
public interface Parser<T> {
    public Cursor getCursor();

    public void setCursor(Cursor cursor);

    public T parse() throws Exception;
}
