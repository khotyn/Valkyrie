/**
 * Project: Valkyrie
 * 
 * File Created at Nov 24, 2011
 * $Id$
 * 
 * This is some code written by khotyn, and you are free to distribute those code for any use.
 * Welcome to my website: http://khotyn.com
 * Free we will be!
 */
package com.khotyn.valkyrie.attribute.parser;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.AccessFlags;
import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.InnerClass;
import com.khotyn.valkyrie.attribute.InnerClasses;

/**
 * Parser to parse {@link InnerClasses}
 * 
 * @author khotyn
 * 
 */
public class InnerClassesParser extends AttributeParser {

    /**
     * @param clazz
     */
    public InnerClassesParser(Clazz clazz) {
        super(clazz);
    }

    /*
     * (non-Javadoc)
     * @see com.khotyn.valkyrie.attribute.parser.AttributeParser#parse(java.lang.String)
     */
    @Override
    public Attribute parse(String str) {
        InnerClasses result = new InnerClasses();
        int cursor = 0;
        result.setLength(str.length() / 2);
        int numberOfClass = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
        List<InnerClass> innerClasses = new ArrayList<InnerClass>();

        for (int i = 0; i < numberOfClass; i++) {
            InnerClass innerClass = new InnerClass();
            innerClass.setInnerClassInfo(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            innerClass.setOuterClassInfo(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));
            innerClass.setInnerName(Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16));

            List<AccessFlags> accFlags = new ArrayList<AccessFlags>();
            int accessFlags = Integer.parseInt(str.substring(cursor, cursor += Clazz.U2), 16);
            for (AccessFlags accFlag : AccessFlags.values()) {
                if ((accessFlags & accFlag.flag) == accFlag.flag) {
                    accFlags.add(accFlag);
                }
            }
            innerClass.setInnerClassAccessFlags(accFlags);

            innerClasses.add(innerClass);
        }

        return result;
    }
}
