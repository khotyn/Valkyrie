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
 * TODO Comment of Code
 * 
 * @author khotyn
 */
public class Code extends Attribute {

    public static ConstantUTF8 name = CODE;
    private int                maxStack;
    private int                maxLocals;
    private String             code;
    private List<ExceptionTable>    exceptionTable;
    private List<Attribute>    attributes;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ExceptionTable> getExceptionTable() {
        return exceptionTable;
    }

    public void setExceptionTable(List<ExceptionTable> exceptionTable) {
        this.exceptionTable = exceptionTable;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
