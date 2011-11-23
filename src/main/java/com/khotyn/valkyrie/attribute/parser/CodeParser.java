package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.Code;

/**
 * {@link Code} parser
 * 
 * @author khotyn 2011-11-23 下午4:54:42
 */
public class CodeParser implements AttributeParser {

    @Override
    public Attribute parse(String str) {
        Code code = new Code();
        int cursor = 0;
        code.setMaxStack(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
        code.setMaxLocals(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
        int codeLength = Integer.parseInt(str.substring(cursor, cursor += Clazz.U4), 16);
        code.setCode(str.substring(cursor, cursor += (codeLength * 2)));
        return code;
    }
}
