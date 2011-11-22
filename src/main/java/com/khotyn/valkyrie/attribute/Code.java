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
 * TODO Comment of Code
 * 
 * @author khotyn
 * 
 */
public class Code extends Attribute {
    protected String        name = CODE;
    private int             maxStack;
    private int             maxLocals;
    private int             codeLength;
    private String          code;
    private List<Exception> exceptionTable;
    private List<Attribute> attributes;

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Exception> getExceptionTable() {
        return exceptionTable;
    }

    public void setExceptionTable(List<Exception> exceptionTable) {
        this.exceptionTable = exceptionTable;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
