package com.khotyn.valkyrie.attribute.parser;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
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

    private ExceptionTableParser exceptionTableParser = new ExceptionTableParser(getCursor());
    private ClassParser          classParser;

    public CodeParser(Clazz clazz, Cursor cursor, ClassParser classParser){
        super(clazz, cursor);
        this.classParser = classParser;
    }

    @Override
    public Attribute parse() throws Exception {
        Code code = new Code();
        code.setLength(getCursor().u4());
        code.setMaxStack(getCursor().u2());
        code.setMaxLocals(getCursor().u2());
        int codeLength = getCursor().u4();
        code.setCode(getCursor().getSubStr(codeLength * 2));

        int exceptionTableLength = getCursor().u2();
        List<ExceptionTable> exceptionTables = new ArrayList<ExceptionTable>(exceptionTableLength);
        for (int i = 0; i < exceptionTableLength; i++) {
            exceptionTables.add(exceptionTableParser.parse());
        }
        code.setExceptionTable(exceptionTables);

        int attributeCount = getCursor().u2();
        List<Attribute> attributes = new ArrayList<Attribute>(attributeCount);
        for (int i = 0; i < attributeCount; i++) {
            int nameIndex = getCursor().u2() - 1;
            ConstantUTF8 attributeName = (ConstantUTF8) getClazz().getConstantPoolInfos().get(nameIndex);
            attributes.add(classParser.parsers.get(attributeName).parse());
        }
        code.setAttributes(attributes);

        return code;
    }
}
