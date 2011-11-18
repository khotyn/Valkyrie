package com.khotyn.valkyrie.parser;

import com.khotyn.valkyrie.*;
import com.khotyn.valkyrie.constant.*;
import com.khotyn.valkyrie.exception.IllegalClassException;
import com.khotyn.valkyrie.util.ValkyrieUtil;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * User: khotyn
 * Date: 11-11-18
 * Time: AM12:20
 * Dust to dust, earth to earth.
 */
public class ClassParser {
    private static ClassParser classParser = new ClassParser();
    private int cursor = 0; // The cursor of the reader in the byte code.
    private byte[] byteCode = null; // The byte code of the class

    /**
     * Get an instance of ClassParser
     *
     * @return An instance of ClassParser
     */
    public static ClassParser getInstance() {
        classParser.reset();
        return classParser;
    }

    /**
     * Parse the byte code to a Clazz representing the structure of the byte code.
     *
     * @param byteCode the byte code to parse
     * @return A Clazz representing the structure of the byte code.
     * @throws IllegalClassException Throws when che byte code is an illegal one.
     */
    public Clazz parse(byte[] byteCode) throws IllegalClassException {
        String byteString = ValkyrieUtil.byteArrayToHexString(byteCode);
        Clazz clazz = new Clazz();

        if (!validate(byteString)) {
            throw new IllegalClassException("Invalid Magic Number");
        }

        parseVersion(clazz, byteString);
        parseConstantPool(clazz, byteString);
        return clazz;
    }

    private void parseVersion(Clazz clazz, String byteString) {
        clazz.setMinorVersion(Integer.parseInt(byteString.substring(cursor, cursor += 4), 16));
        clazz.setMajorVersion(Integer.parseInt(byteString.substring(cursor, cursor += 4), 16));
    }

    private void parseConstantPool(Clazz clazz, String byteString) {
        int constantPoolSize = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16) - 1;
        List<ConstantPoolInfo> constantPoolInfoes = new ArrayList<ConstantPoolInfo>(constantPoolSize);

        for (int i = 0; i < constantPoolSize; i++) {
            int tag = Integer.parseInt(byteString.substring(cursor, cursor += 2), 16);

            switch (tag) {
                case ConstantPoolInfo.CONSTANT_UTF8:
                    ConstantUTF8 constantUTF8 = new ConstantUTF8();
                    int utf8Length = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    constantUTF8.content = ValkyrieUtil.hexStringToASCIIString(byteString.substring(cursor, cursor += utf8Length * 2));
                    constantPoolInfoes.add(constantUTF8);
                    break;
                case ConstantPoolInfo.CONSTANT_CLASS:
                    ConstantClass constantClass = new ConstantClass();
                    constantClass.nameIndex = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    constantPoolInfoes.add(constantClass);
                    break;
                case ConstantPoolInfo.CONSTANT_STRING:
                    ConstantString string = new ConstantString();
                    string.stringIndex = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    constantPoolInfoes.add(string);
                    break;
                case ConstantPoolInfo.CONSTANT_FIELD_REF:
                    ConstantFieldRef fieldRef = new ConstantFieldRef();
                    fieldRef.classIndex = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    fieldRef.nameAndTypeIndex = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    constantPoolInfoes.add(fieldRef);
                    break;
                case ConstantPoolInfo.CONSTANT_METHOD_REF:
                    ConstantMethodRef methodRef = new ConstantMethodRef();
                    methodRef.classIndex = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    methodRef.nameAndTypeIndex = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    constantPoolInfoes.add(methodRef);
                    break;
                case ConstantPoolInfo.CONSTANT_NAME_AND_TYPE:
                    ConstantNameAndType nameAndType = new ConstantNameAndType();
                    nameAndType.nameIndex = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    nameAndType.descriptorIndex = Integer.parseInt(byteString.substring(cursor, cursor += 4), 16);
                    constantPoolInfoes.add(nameAndType);
                    break;
                default:
                    break;
            }
        }

        clazz.setConstantPoolInfos(constantPoolInfoes);
    }

    private boolean validate(String byteString) {
        if (byteString.length() < Clazz.MAGIC_NUMBER.length()) {
            return false;
        }

        return byteString.substring(cursor, cursor += Clazz.MAGIC_NUMBER.length()).equalsIgnoreCase(Clazz.MAGIC_NUMBER);
    }

    /**
     * Reset the class parser to the initial status for reuse
     */
    public void reset() {
        this.cursor = 0;
        this.byteCode = null;
    }
}
