/**
 * Project: Valkyrie
 * 
 * File Created at Nov 26, 2011
 * $Id$
 * 
 * This is some code written by khotyn, and you are free to distribute those code for any use.
 * Welcome to my website: http://khotyn.com
 * Free we will be!
 */
package com.khotyn.valkyrie.attribute.parser;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.BootstrapMethod;
import com.khotyn.valkyrie.attribute.BootstrapMethods;

/**
 * Parser to parse {@link BootstrapMethods}
 * 
 * @author khotyn
 * 
 */
public class BootstrapMethodsParser extends AttributeParser {

    /**
     * @param clazz
     * @param cursor
     */
    public BootstrapMethodsParser(Clazz clazz, Cursor cursor) {
        super(clazz, cursor);
    }

    @Override
    public Attribute parse() throws Exception {
        BootstrapMethods result = new BootstrapMethods();
        result.setLength(getCursor().u4());
        int numberOfBootstrapMethods = getCursor().u2();
        List<BootstrapMethod> bootstrapMethods = new ArrayList<BootstrapMethod>(numberOfBootstrapMethods);

        for (int i = 0; i < numberOfBootstrapMethods; i++) {
            BootstrapMethod bootstrapMethod = new BootstrapMethod();
            bootstrapMethod.setMethodRef(getCursor().u2());
            int numberOfArguments = getCursor().u2();
            List<Integer> arguments = new ArrayList<Integer>(numberOfArguments);

            for (int j = 0; j < numberOfArguments; j++) {
                arguments.add(getCursor().u2());
            }

            bootstrapMethod.setArguments(arguments);
            bootstrapMethods.add(bootstrapMethod);
        }

        result.setBootstrapMethods(bootstrapMethods);
        return result;
    }

}
