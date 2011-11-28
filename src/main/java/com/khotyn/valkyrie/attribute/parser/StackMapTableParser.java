package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.StackMapTable;

public class StackMapTableParser extends AttributeParser {
    /**
     * @param clazz
     * @param cursor
     */
    public StackMapTableParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() {
        StackMapTable stackMapTable = new StackMapTable();
        stackMapTable.setLength(getCursor().u4());
        int numberOfEntries = getCursor().u2();

        for (int i = 0; i < numberOfEntries; i++) {
        }

        return stackMapTable;
    }

}
