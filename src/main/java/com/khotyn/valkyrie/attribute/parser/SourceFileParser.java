package com.khotyn.valkyrie.attribute.parser;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.SourceFile;

/**
 * Parser to parse the {@link SourceFile} attribute
 * 
 * @author khotyn 2011-11-23 PM3:28:55
 */
public class SourceFileParser extends AttributeParser {

    public SourceFileParser(Clazz clazz) {
        super(clazz);
    }

    @Override
    public Attribute parse(String str) {
        SourceFile result = new SourceFile();
        result.setLength(str.length() / 2);
        result.setSourcefileIndex(Integer.parseInt(str.substring(0, Clazz.U2), 16));
        return result;
    }
}
