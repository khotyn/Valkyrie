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
    public Attribute parse() {
        SourceFile result = new SourceFile();
        result.setLength(getCursor().u4());
        result.setSourcefileIndex(getCursor().u2());
        return result;
    }
}
