package com.khotyn.valkyrie.attribute.parser;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.Code;
import com.khotyn.valkyrie.attribute.ExceptionTable;
import com.khotyn.valkyrie.constant.ConstantUTF8;
import com.khotyn.valkyrie.parser.ClassParser;

/**
 * {@link Code} parser
 * 
 * @author khotyn 2011-11-23 下午4:54:42
 */
public class CodeParser extends AttributeParser {

    public CodeParser(Clazz clazz){
        super(clazz);
    }

    @Override
    public Attribute parse(String str) {
        Code code = new Code();
        int cursor = 0;
        code.setMaxStack(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
        code.setMaxLocals(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
        int codeLength = Integer.parseInt(str.substring(cursor, cursor += Clazz.U4), 16);
        code.setCode(str.substring(cursor, cursor += (codeLength * 2)));

        int exceptionTableLength = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
        List<ExceptionTable> exceptionTables = new ArrayList<ExceptionTable>(exceptionTableLength);
        for (int i = 0; i < exceptionTableLength; i++) {
            exceptionTables.add(ExceptionTableParser.parse(str.substring(cursor, cursor += (4 * Clazz.U2))));
        }
        code.setExceptionTable(exceptionTables);

        int attributeCount = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
        List<Attribute> attributes = new ArrayList<Attribute>(attributeCount);
        for (int i = 0; i < attributeCount; i++) {
            int nameIndex = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16) - 1;
            ConstantUTF8 attributeName = (ConstantUTF8) getClazz().getConstantPoolInfos().get(nameIndex);
            int attrLength = Integer.parseInt(str.substring(cursor, cursor += Clazz.U4), 16);

            attributes.add(ClassParser.getInstance().parsers.get(attributeName).parse(str.substring(cursor,
                                                                                                    cursor += (attrLength * 2))));
        }
        code.setAttributes(attributes);

        return code;
    }
}
