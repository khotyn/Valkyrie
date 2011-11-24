package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.ExceptionTable;
import com.khotyn.valkyrie.parser.Parser;

public class ExceptionTableParser implements Parser<ExceptionTable> {
    private Cursor cursor;

    public ExceptionTableParser(Cursor cursor) {
        this.cursor = cursor;
    }

    public ExceptionTable parse() {
        ExceptionTable exceptionTable = new ExceptionTable();

        exceptionTable.setStartPC(cursor.u2());
        exceptionTable.setEndPC(cursor.u2());
        exceptionTable.setHandlerPC(cursor.u2());
        exceptionTable.setCatchType(cursor.u2());

        return exceptionTable;
    }

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
