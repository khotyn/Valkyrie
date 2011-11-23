package com.khotyn.valkyrie.parser;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.AccessFlags;
import com.khotyn.valkyrie.BytecodeBehavior;
import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.ConstantPoolInfo;
import com.khotyn.valkyrie.Field;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.constant.ConstantClass;
import com.khotyn.valkyrie.constant.ConstantDouble;
import com.khotyn.valkyrie.constant.ConstantFieldRef;
import com.khotyn.valkyrie.constant.ConstantFloat;
import com.khotyn.valkyrie.constant.ConstantInteger;
import com.khotyn.valkyrie.constant.ConstantInterfaceMethodRef;
import com.khotyn.valkyrie.constant.ConstantInvokeDynamic;
import com.khotyn.valkyrie.constant.ConstantLong;
import com.khotyn.valkyrie.constant.ConstantMethodHandle;
import com.khotyn.valkyrie.constant.ConstantMethodRef;
import com.khotyn.valkyrie.constant.ConstantMethodType;
import com.khotyn.valkyrie.constant.ConstantNameAndType;
import com.khotyn.valkyrie.constant.ConstantString;
import com.khotyn.valkyrie.constant.ConstantUTF8;
import com.khotyn.valkyrie.exception.IllegalClassException;
import com.khotyn.valkyrie.util.ValkyrieUtil;

/**
 * User: khotyn Date: 11-11-18 Time: AM12:20 Dust to dust, earth to earth.
 */
public class ClassParser {

    private static ClassParser classParser = new ClassParser();
    private int                cursor      = 0;                // The cursor of the reader in the byte code.

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

        clazz.setMinorVersion(Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16));
        clazz.setMajorVersion(Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16));

        clazz.setConstantPoolInfos(parseConstantPool(byteString));
        clazz.setAccessFlags(parseAccessFlags(byteString));
        clazz.setThisClass(parseThisClass(byteString));
        clazz.setSuperClass(parseSuperClass(byteString));
        clazz.setInterfaces(parseInterfaces(byteString));
        clazz.setFields(parseFields(byteString));
        return clazz;
    }

    private List<ConstantPoolInfo> parseConstantPool(String byteString) {
        int constantPoolSize = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16) - 1;
        List<ConstantPoolInfo> constantPoolInfoes = new ArrayList<ConstantPoolInfo>(constantPoolSize);

        for (int i = 0; i < constantPoolSize; i++) {
            int tag = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U1), 16);

            switch (tag) {
            case ConstantPoolInfo.CONSTANT_UTF8:
                ConstantUTF8 constantUTF8 = new ConstantUTF8();
                int utf8Length = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantUTF8.content = ValkyrieUtil.hexStringToASCIIString(byteString.substring(cursor, cursor += utf8Length * 2));
                constantPoolInfoes.add(constantUTF8);
                break;
            case ConstantPoolInfo.CONSTANT_INTEGER:
                ConstantInteger constantInteger = new ConstantInteger();
                constantInteger.value = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U4), 16);
                constantPoolInfoes.add(constantInteger);
                break;
            case ConstantPoolInfo.CONSTANT_FLOAT:
                ConstantFloat constantFloat = new ConstantFloat();
                int bits = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U4), 16);
                int s = ((bits >> 31) == 0) ? 1 : -1;
                int e = (bits >> 23) & 0xff;
                int m = (e == 0) ? (bits & 0x7fffff) << 1 : (bits & 0x7fffff) | 0x800000;
                constantFloat.value = s * m * (float) Math.pow(2.0, e - 150);
                constantPoolInfoes.add(constantFloat);
                break;
            case ConstantPoolInfo.CONSTANT_LONG:
                ConstantLong constantLong = new ConstantLong();
                constantLong.value = Long.parseLong(byteString.substring(cursor, cursor += (Clazz.U4 * 2)), 16);
                constantPoolInfoes.add(constantLong);
                constantPoolInfoes.add(null);
                i++;
                break;
            case ConstantPoolInfo.CONSTANT_DOUBLE:
                ConstantDouble constantDouble = new ConstantDouble();
                long lbits = Long.parseLong(byteString.substring(cursor, cursor += (Clazz.U4 * 2)), 16);
                int ls = ((lbits >> 63) == 0) ? 1 : -1;
                int le = (int) ((lbits >> 52) & 0x7ffL);
                long lm = (le == 0) ? (lbits & 0xfffffffffffffL) << 1 : (lbits & 0xfffffffffffffL) | 0x10000000000000L;
                constantDouble.value = ls * lm * Math.pow(2.0, le - 1075);
                constantPoolInfoes.add(constantDouble);
                constantPoolInfoes.add(null);
                i++;
                break;
            case ConstantPoolInfo.CONSTANT_CLASS:
                ConstantClass constantClass = new ConstantClass();
                constantClass.nameIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(constantClass);
                break;
            case ConstantPoolInfo.CONSTANT_STRING:
                ConstantString string = new ConstantString();
                string.stringIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(string);
                break;
            case ConstantPoolInfo.CONSTANT_FIELD_REF:
                ConstantFieldRef fieldRef = new ConstantFieldRef();
                fieldRef.classIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                fieldRef.nameAndTypeIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(fieldRef);
                break;
            case ConstantPoolInfo.CONSTANT_METHOD_REF:
                ConstantMethodRef methodRef = new ConstantMethodRef();
                methodRef.classIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                methodRef.nameAndTypeIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(methodRef);
                break;
            case ConstantPoolInfo.CONSTANT_INTERFACE_METHOD_REF:
                ConstantInterfaceMethodRef constantInterfaceMethodRef = new ConstantInterfaceMethodRef();
                constantInterfaceMethodRef.classIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantInterfaceMethodRef.nameAndTypeIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(constantInterfaceMethodRef);
                break;
            case ConstantPoolInfo.CONSTANT_NAME_AND_TYPE:
                ConstantNameAndType nameAndType = new ConstantNameAndType();
                nameAndType.nameIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                nameAndType.descriptorIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(nameAndType);
                break;
            case ConstantPoolInfo.CONSTANT_METHOD_HANDLE:
                ConstantMethodHandle constantMethodHandle = new ConstantMethodHandle();
                constantMethodHandle.referenceKind = BytecodeBehavior.getInstance(Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U1),
                        16));
                constantMethodHandle.referenceIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(constantMethodHandle);
                break;
            case ConstantPoolInfo.CONSTANT_METHOD_TYPE:
                ConstantMethodType constantMethodType = new ConstantMethodType();
                constantMethodType.descriptorIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(constantMethodType);
                break;
            case ConstantPoolInfo.CONSTANT_INVOKE_DYNAMIC:
                ConstantInvokeDynamic constantInvokeDynamic = new ConstantInvokeDynamic();
                constantInvokeDynamic.bootstrapMethodAttrIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantInvokeDynamic.nameAndTypeIndex = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
                constantPoolInfoes.add(constantInvokeDynamic);
                break;
            default:
                break;
            }
        }

        return constantPoolInfoes;
    }

    private List<AccessFlags> parseAccessFlags(String byteString) {
        List<AccessFlags> accFlags = new ArrayList<AccessFlags>();
        int accessFlags = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);

        for (AccessFlags accFlag : AccessFlags.values()) {
            if ((accessFlags & accFlag.flag) == accFlag.flag) {
                accFlags.add(accFlag);
            }
        }

        return accFlags;
    }

    private int parseThisClass(String byteString) {
        return Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
    }

    private int parseSuperClass(String byteString) {
        return Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
    }

    private List<Integer> parseInterfaces(String byteString) {
        int size = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
        List<Integer> interfaces = new ArrayList<Integer>(size);

        for (int i = 0; i < size; i++) {
            interfaces.add(Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16));
        }

        return interfaces;
    }

    private List<Field> parseFields(String byteString) {
        int size = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
        List<Field> fields = new ArrayList<Field>();

        for (int i = 0; i < size; i++) {
            Field field = new Field();
            field.setAccessFlags(parseAccessFlags(byteString));
            field.setNameIndex(Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16));
            field.setDescriptorIndex(Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16));

            int attributesCount = Integer.parseInt(byteString.substring(cursor, cursor += Clazz.U2), 16);
            List<Attribute> attributes = new ArrayList<Attribute>(attributesCount);

            for (int j = 0; j < attributesCount; j++) {
                attributes.add(parseAttribute(byteString));
            }

            field.setAttributes(attributes);
        }

        return fields;
    }

    private Attribute parseAttribute(String byteString) {
        return new Attribute();
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
    }
}
