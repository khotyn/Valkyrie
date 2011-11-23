package com.khotyn.valkyrie.attribute;

import java.util.List;

import com.khotyn.valkyrie.constant.ConstantUTF8;

/**
 * TODO: LocalVariableTable.java
 * 
 * @author khotyn 2011-11-23 上午10:10:37
 */
public class LocalVariableTable extends Attribute {

    public static ConstantUTF8  name = LOCAL_VARIABLE_TABLE;

    private List<LocalVariable> localVariableTable;

    public List<LocalVariable> getLocalVariableTable() {
        return localVariableTable;
    }

    public void setLocalVariableTable(List<LocalVariable> localVariableTable) {
        this.localVariableTable = localVariableTable;
    }
}
