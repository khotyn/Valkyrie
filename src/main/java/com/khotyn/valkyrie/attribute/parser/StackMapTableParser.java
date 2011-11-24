package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.StackMapTable;

public class StackMapTableParser extends AttributeParser {

    public StackMapTableParser(Clazz clazz) {
        super(clazz);
    }

    @Override
    public Attribute parse(String str) {
        StackMapTable stackMapTable = new StackMapTable();
        int cursor = 0;
        stackMapTable.setLength(str.length() / 2);
        int numberOfEntries = Integer.parseInt(str.substring(cursor, cursor += 2), 16);

        for (int i = 0; i < numberOfEntries; i++) {
        }

        return stackMapTable;
    }

}
