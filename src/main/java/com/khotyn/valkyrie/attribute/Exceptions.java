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

import com.khotyn.valkyrie.constant.ConstantClass;

/**
 * TODO Comment of Exceptions
 * 
 * @author khotyn
 * 
 */
public class Exceptions extends Attribute {
    protected String            name = EXCEPTIONS;
    private List<ConstantClass> exceptionIndexTable;

    public List<ConstantClass> getExceptionIndexTable() {
        return exceptionIndexTable;
    }

    public void setExceptionIndexTable(List<ConstantClass> exceptionIndexTable) {
        this.exceptionIndexTable = exceptionIndexTable;
    }
}
