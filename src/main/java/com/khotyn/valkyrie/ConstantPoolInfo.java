package com.khotyn.valkyrie;

public class ConstantPoolInfo {
    protected int tag = 0;

    public static final int CONSTANT_UTF8 = 0x01;
    public static final int CONSTANT_INTEGER = 0x03;
    public static final int CONSTANT_FLOAT = 0x04;
    public static final int CONSTANT_LONG = 0x05;
    public static final int CONSTANT_DOUBLE = 0x06;
    public static final int CONSTANT_CLASS = 0x07;
    public static final int CONSTANT_STRING = 0x08;
    public static final int CONSTANT_FIELD_REF = 0x09;
    public static final int CONSTANT_METHOD_REF = 0x0A;
    public static final int CONSTANT_INTERFACE_METHOD_REF = 0x0B;
    public static final int CONSTANT_NAME_AND_TYPE = 0x0C;
    public static final int CONSTANT_METHOD_HANDLE = 0x0F;
    public static final int CONSTANT_METHOD_TYPE = 0x10;
    public static final int CONSTANT_INVOKE_DYNAMIC = 0x12;
}
