package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.ExceptionTable;

public class ExceptionTableParser {

    public static ExceptionTable parse(String str) {
        int cursor = 0;
        ExceptionTable exceptionTable = new ExceptionTable();

        exceptionTable.setStartPC(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
        exceptionTable.setEndPC(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
        exceptionTable.setHandlerPC(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
        exceptionTable.setCatchType(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));

        return exceptionTable;
    }
}
