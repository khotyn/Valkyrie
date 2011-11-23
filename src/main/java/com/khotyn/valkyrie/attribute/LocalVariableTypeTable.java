package com.khotyn.valkyrie.attribute;

import java.util.List;

/**
 * TODO: LocalVariableTypeTable.java
 * 
 * @author khotyn 2011-11-23 上午10:14:40
 */
public class LocalVariableTypeTable extends Attribute {

    protected String                name = LOCAL_VARIABLE_TYPE_TABLE;
    private List<LocalVariableType> localVariableType;

    public List<LocalVariableType> getLocalVariableType() {
        return localVariableType;
    }

    public void setLocalVariableType(List<LocalVariableType> localVariableType) {
        this.localVariableType = localVariableType;
    }
}
