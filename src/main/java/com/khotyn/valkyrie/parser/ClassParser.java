package com.khotyn.valkyrie.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.khotyn.valkyrie.AccessFlags;
import com.khotyn.valkyrie.BytecodeBehavior;
import com.khotyn.valkyrie.Clazz;
import com.khotyn.valkyrie.Cursor;
import com.khotyn.valkyrie.Field;
import com.khotyn.valkyrie.Method;
import com.khotyn.valkyrie.attribute.Attribute;
import com.khotyn.valkyrie.attribute.parser.AnnotationDefaultParser;
import com.khotyn.valkyrie.attribute.parser.AttributeParser;
import com.khotyn.valkyrie.attribute.parser.BootstrapMethodsParser;
import com.khotyn.valkyrie.attribute.parser.CodeParser;
import com.khotyn.valkyrie.attribute.parser.ConstantValueParser;
import com.khotyn.valkyrie.attribute.parser.DeprecatedParser;
import com.khotyn.valkyrie.attribute.parser.EnclosingMethodParser;
import com.khotyn.valkyrie.attribute.parser.ExceptionsParser;
import com.khotyn.valkyrie.attribute.parser.InnerClassesParser;
import com.khotyn.valkyrie.attribute.parser.LineNumberTableParser;
import com.khotyn.valkyrie.attribute.parser.LocalVariableTableParser;
import com.khotyn.valkyrie.attribute.parser.LocalVariableTypeTableParser;
import com.khotyn.valkyrie.attribute.parser.RuntimeInvisibleAnnotationsParser;
import com.khotyn.valkyrie.attribute.parser.RuntimeInvisibleParameterAnnotationsParser;
import com.khotyn.valkyrie.attribute.parser.RuntimeVisibleAnnotationsParser;
import com.khotyn.valkyrie.attribute.parser.RuntimeVisibleParameterAnnotationsParser;
import com.khotyn.valkyrie.attribute.parser.SignatureParser;
import com.khotyn.valkyrie.attribute.parser.SourceDebugExtensionParser;
import com.khotyn.valkyrie.attribute.parser.SourceFileParser;
import com.khotyn.valkyrie.attribute.parser.StackMapTableParser;
import com.khotyn.valkyrie.attribute.parser.SyntheticParser;
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
import com.khotyn.valkyrie.constant.ConstantPoolInfo;
import com.khotyn.valkyrie.constant.ConstantString;
import com.khotyn.valkyrie.constant.ConstantUTF8;
import com.khotyn.valkyrie.exception.IllegalClassException;
import com.khotyn.valkyrie.util.ValkyrieUtil;

/**
 * User: khotyn Date: 11-11-18 Time: AM12:20 Dust to dust, earth to earth.
 */
public class ClassParser implements Parser<Clazz> {

    private Cursor                            cursor;
    private Clazz                             clazz;

    public Map<ConstantUTF8, AttributeParser> parsers = new HashMap<ConstantUTF8, AttributeParser>();

    public ClassParser(byte[] byteCode){
        cursor = new Cursor(ValkyrieUtil.byteArrayToHexString(byteCode));
        clazz = new Clazz();
        parsers.put(Attribute.CONSTANT_VALUE, new ConstantValueParser(clazz, cursor));
        parsers.put(Attribute.CODE, new CodeParser(clazz, cursor, this));
        parsers.put(Attribute.STACK_MAP_TABLE, new StackMapTableParser(clazz, cursor));
        parsers.put(Attribute.EXCEPTIONS, new ExceptionsParser(clazz, cursor));
        parsers.put(Attribute.INNER_CLASSES, new InnerClassesParser(clazz, cursor));
        parsers.put(Attribute.ENCLOSING_METHOD, new EnclosingMethodParser(clazz, cursor));
        parsers.put(Attribute.SYNTHETIC, new SyntheticParser(clazz, cursor));
        parsers.put(Attribute.SIGNATURE, new SignatureParser(clazz, cursor));
        parsers.put(Attribute.SOURCE_FILE, new SourceFileParser(clazz, cursor));
        parsers.put(Attribute.SOURCE_DEBUG_EXTENSION, new SourceDebugExtensionParser(clazz, cursor));
        parsers.put(Attribute.LINE_NUMBER_TABLE, new LineNumberTableParser(clazz, cursor));
        parsers.put(Attribute.LOCAL_VARIABLE_TABLE, new LocalVariableTableParser(clazz, cursor));
        parsers.put(Attribute.LOCAL_VARIABLE_TYPE_TABLE, new LocalVariableTypeTableParser(clazz, cursor));
        parsers.put(Attribute.DEPRECATED, new DeprecatedParser(clazz, cursor));
        parsers.put(Attribute.RUNTIME_VISIBLE_ANNOTATIONS, new RuntimeVisibleAnnotationsParser(clazz, cursor));
        parsers.put(Attribute.RUNTIME_INVISIBLE_ANNOTATIONS, new RuntimeInvisibleAnnotationsParser(clazz, cursor));
        parsers.put(Attribute.RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS,
                    new RuntimeVisibleParameterAnnotationsParser(clazz, cursor));
        parsers.put(Attribute.RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS,
                    new RuntimeInvisibleParameterAnnotationsParser(clazz, cursor));
        parsers.put(Attribute.ANNOTAION_DEFAULT, new AnnotationDefaultParser(clazz, cursor));
        parsers.put(Attribute.BOOTSTRAP_METHODS, new BootstrapMethodsParser(clazz, cursor));
    }

    /**
     * Parse the byte code to a Clazz representing the structure of the byte code.
     * 
     * @param byteCode the byte code to parse
     * @return A Clazz representing the structure of the byte code.
     * @throws IllegalClassException Throws when che byte code is an illegal one.
     */
    public Clazz parse() throws Exception {

        if (!validate()) {
            throw new IllegalClassException("Invalid Magic Number");
        }

        clazz.setMinorVersion(cursor.u2());
        clazz.setMajorVersion(cursor.u2());

        clazz.setConstantPoolInfos(parseConstantPool());
        clazz.setAccessFlags(parseAccessFlags());
        clazz.setThisClass(parseThisClass());
        clazz.setSuperClass(parseSuperClass());
        clazz.setInterfaces(parseInterfaces());
        clazz.setFields(parseFields());
        clazz.setMethods(parseMethods());
        clazz.setAttributes(parseAttributes());
        return clazz;
    }

    private List<ConstantPoolInfo> parseConstantPool() {
        int constantPoolSize = cursor.u2() - 1;
        List<ConstantPoolInfo> constantPool = new ArrayList<ConstantPoolInfo>(constantPoolSize);

        for (int i = 0; i < constantPoolSize; i++) {
            int tag = cursor.u1();

            switch (tag) {
                case ConstantPoolInfo.CONSTANT_UTF8:
                    int utf8Length = cursor.u2();
                    constantPool.add(new ConstantUTF8(
                                                      ValkyrieUtil.hexStringToASCIIString(cursor.getSubStr(utf8Length * 2))));
                    break;
                case ConstantPoolInfo.CONSTANT_INTEGER:
                    ConstantInteger constantInteger = new ConstantInteger(constantPool);
                    constantInteger.value = cursor.u4();
                    constantPool.add(constantInteger);
                    break;
                case ConstantPoolInfo.CONSTANT_FLOAT:
                    ConstantFloat constantFloat = new ConstantFloat(constantPool);
                    int bits = cursor.u4();
                    int s = ((bits >> 31) == 0) ? 1 : -1;
                    int e = (bits >> 23) & 0xff;
                    int m = (e == 0) ? (bits & 0x7fffff) << 1 : (bits & 0x7fffff) | 0x800000;
                    constantFloat.value = s * m * (float) Math.pow(2.0, e - 150);
                    constantPool.add(constantFloat);
                    break;
                case ConstantPoolInfo.CONSTANT_LONG:
                    ConstantLong constantLong = new ConstantLong(constantPool);
                    constantLong.value = Long.parseLong(cursor.getSubStr(Cursor.U4 * 2), 16);
                    constantPool.add(constantLong);
                    constantPool.add(null);
                    i++;
                    break;
                case ConstantPoolInfo.CONSTANT_DOUBLE:
                    ConstantDouble constantDouble = new ConstantDouble(constantPool);
                    long lbits = Long.parseLong(cursor.getSubStr(Cursor.U4 * 2), 16);
                    int ls = ((lbits >> 63) == 0) ? 1 : -1;
                    int le = (int) ((lbits >> 52) & 0x7ffL);
                    long lm = (le == 0) ? (lbits & 0xfffffffffffffL) << 1 : (lbits & 0xfffffffffffffL) | 0x10000000000000L;
                    constantDouble.value = ls * lm * Math.pow(2.0, le - 1075);
                    constantPool.add(constantDouble);
                    constantPool.add(null);
                    i++;
                    break;
                case ConstantPoolInfo.CONSTANT_CLASS:
                    ConstantClass constantClass = new ConstantClass(constantPool);
                    constantClass.nameIndex = cursor.u2();
                    constantPool.add(constantClass);
                    break;
                case ConstantPoolInfo.CONSTANT_STRING:
                    ConstantString string = new ConstantString(constantPool);
                    string.stringIndex = cursor.u2();
                    constantPool.add(string);
                    break;
                case ConstantPoolInfo.CONSTANT_FIELD_REF:
                    ConstantFieldRef fieldRef = new ConstantFieldRef(constantPool);
                    fieldRef.classIndex = cursor.u2();
                    fieldRef.nameAndTypeIndex = cursor.u2();
                    constantPool.add(fieldRef);
                    break;
                case ConstantPoolInfo.CONSTANT_METHOD_REF:
                    ConstantMethodRef methodRef = new ConstantMethodRef(constantPool);
                    methodRef.classIndex = cursor.u2();
                    methodRef.nameAndTypeIndex = cursor.u2();
                    constantPool.add(methodRef);
                    break;
                case ConstantPoolInfo.CONSTANT_INTERFACE_METHOD_REF:
                    ConstantInterfaceMethodRef constantInterfaceMethodRef = new ConstantInterfaceMethodRef(constantPool);
                    constantInterfaceMethodRef.classIndex = cursor.u2();
                    constantInterfaceMethodRef.nameAndTypeIndex = cursor.u2();
                    constantPool.add(constantInterfaceMethodRef);
                    break;
                case ConstantPoolInfo.CONSTANT_NAME_AND_TYPE:
                    ConstantNameAndType nameAndType = new ConstantNameAndType(constantPool);
                    nameAndType.nameIndex = cursor.u2();
                    nameAndType.descriptorIndex = cursor.u2();
                    constantPool.add(nameAndType);
                    break;
                case ConstantPoolInfo.CONSTANT_METHOD_HANDLE:
                    ConstantMethodHandle constantMethodHandle = new ConstantMethodHandle(constantPool);
                    constantMethodHandle.referenceKind = BytecodeBehavior.getInstance(cursor.u1());
                    constantMethodHandle.referenceIndex = cursor.u2();
                    constantPool.add(constantMethodHandle);
                    break;
                case ConstantPoolInfo.CONSTANT_METHOD_TYPE:
                    ConstantMethodType constantMethodType = new ConstantMethodType(constantPool);
                    constantMethodType.descriptorIndex = cursor.u2();
                    constantPool.add(constantMethodType);
                    break;
                case ConstantPoolInfo.CONSTANT_INVOKE_DYNAMIC:
                    ConstantInvokeDynamic constantInvokeDynamic = new ConstantInvokeDynamic(constantPool);
                    constantInvokeDynamic.bootstrapMethodAttrIndex = cursor.u2();
                    constantInvokeDynamic.nameAndTypeIndex = cursor.u2();
                    constantPool.add(constantInvokeDynamic);
                    break;
                default:
                    break;
            }
        }

        return constantPool;
    }

    private List<AccessFlags> parseAccessFlags() {
        List<AccessFlags> accFlags = new ArrayList<AccessFlags>();
        int accessFlags = cursor.u2();

        for (AccessFlags accFlag : AccessFlags.values()) {
            if ((accessFlags & accFlag.flag) == accFlag.flag) {
                accFlags.add(accFlag);
            }
        }

        return accFlags;
    }

    private int parseThisClass() {
        return cursor.u2();
    }

    private int parseSuperClass() {
        return cursor.u2();
    }

    private List<Integer> parseInterfaces() {
        int size = cursor.u2();
        List<Integer> interfaces = new ArrayList<Integer>(size);

        for (int i = 0; i < size; i++) {
            interfaces.add(cursor.u2());
        }

        return interfaces;
    }

    private List<Field> parseFields() throws Exception {
        int size = cursor.u2();
        List<Field> fields = new ArrayList<Field>();

        for (int i = 0; i < size; i++) {
            Field field = new Field();
            field.setAccessFlags(parseAccessFlags());
            field.setNameIndex(cursor.u2());
            field.setDescriptorIndex(cursor.u2());

            int attributesCount = cursor.u2();
            List<Attribute> attributes = new ArrayList<Attribute>(attributesCount);

            for (int j = 0; j < attributesCount; j++) {
                attributes.add(parseAttribute());
            }

            field.setAttributes(attributes);
        }

        return fields;
    }

    private List<Method> parseMethods() throws Exception {
        int number = cursor.u2();
        List<Method> methods = new ArrayList<Method>(number);

        for (int i = 0; i < number; i++) {
            Method method = new Method(clazz);
            method.setAccessFlags(parseAccessFlags());
            method.setNameIndex(getCursor().u2());
            method.setDescriptorIndex(getCursor().u2());
            method.setAttributes(parseAttributes());
            methods.add(method);
        }

        return methods;
    }

    private List<Attribute> parseAttributes() throws Exception {
        int number = getCursor().u2();
        List<Attribute> result = new ArrayList<Attribute>(number);

        for (int i = 0; i < number; i++) {
            result.add(parseAttribute());
        }

        return result;
    }

    private Attribute parseAttribute() throws Exception {
        int nameIndex = cursor.u2() - 1;
        ConstantUTF8 attributeName = (ConstantUTF8) clazz.getConstantPoolInfos().get(nameIndex);
        return parsers.get(attributeName).parse();
    }

    private boolean validate() {
        if (cursor.getByteString().length() < Clazz.MAGIC_NUMBER.length()) {
            return false;
        }

        return cursor.getSubStr(Clazz.MAGIC_NUMBER.length()).equalsIgnoreCase(Clazz.MAGIC_NUMBER);
    }

    /**
     * Reset the class parser to the initial status for reuse
     */
    public void reset() {
        this.cursor = null;
        this.clazz = null;
    }

    @Override
    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
