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
package com.khotyn.valkyrie;

import com.khotyn.valkyrie.util.ValkyrieUtil;

/**
 * The cursor of the bytecode
 * 
 * @author khotyn
 */
public class Cursor {

    public static final int U1     = 2;
    public static final int U2     = U1 * 2;
    public static final int U4     = U2 * 2;
    private int             cursor = 0;
    private String          byteString;

    public String getByteString() {
        return byteString;
    }

    public void setByteString(String byteString) {
        this.byteString = byteString;
    }

    public Cursor(String byteString){
        this.byteString = byteString;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public Cursor forward(int i) {
        cursor += i;
        return this;
    }

    public int u1() {
        return ValkyrieUtil.hexStringToInt(byteString.substring(cursor, cursor += U1));
    }

    public int u2() {
        return ValkyrieUtil.hexStringToInt(byteString.substring(cursor, cursor += U2));
    }

    public int u4() {
        return ValkyrieUtil.hexStringToInt(byteString.substring(cursor, cursor += U4));
    }

    public String getSubStr(int length) {
        return byteString.substring(cursor, cursor += length);
    }

    public Cursor reset() {
        cursor = 0;
        byteString = null;
        return this;
    }
}
