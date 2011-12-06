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

/**
 * @author khotyn
 */
public class ExceptionTable {

    private int startPC;
    private int endPC;
    private int handlerPC;
    private int catchType;

    public int getStartPC() {
        return startPC;
    }

    public void setStartPC(int startPC) {
        this.startPC = startPC;
    }

    public int getEndPC() {
        return endPC;
    }

    public void setEndPC(int endPC) {
        this.endPC = endPC;
    }

    public int getHandlerPC() {
        return handlerPC;
    }

    public void setHandlerPC(int handlerPC) {
        this.handlerPC = handlerPC;
    }

    public int getCatchType() {
        return catchType;
    }

    public void setCatchType(int catchType) {
        this.catchType = catchType;
    }

}
