package com.khotyn.valkyrie.attribute;

import java.util.List;

/**
 * Attribute LineNumberTable
 * 
 * @author khotyn 2011-11-23 AM 9:55:23
 */
public class LineNumberTable extends Attribute {

    protected String         name = LINE_NUMBER_TABLE;
    private List<LineNumber> lineNumberTable;

    public List<LineNumber> getLineNumberTable() {
        return lineNumberTable;
    }

    public void setLineNumberTable(List<LineNumber> lineNumberTable) {
        this.lineNumberTable = lineNumberTable;
    }
}
