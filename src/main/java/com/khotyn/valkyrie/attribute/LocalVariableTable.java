package com.khotyn.valkyrie.attribute;

import java.util.List;

/**
 * TODO: LocalVariableTable.java
 * 
 * @author khotyn 2011-11-23 上午10:10:37
 */
public class LocalVariableTable extends Attribute {

    protected String            name = LOCAL_VARIABLE_TABLE;

    private List<LocalVariable> localVariableTable;

    public List<LocalVariable> getLocalVariableTable() {
        return localVariableTable;
    }

    public void setLocalVariableTable(List<LocalVariable> localVariableTable) {
        this.localVariableTable = localVariableTable;
    }
}
