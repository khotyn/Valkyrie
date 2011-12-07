package com.khotyn.valkyrie.util;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.AccessFlags;

/**
 * User: apple Date: 11-11-18 Time: AM10:39 Dust to dust, earth to earth.
 */
public class ValkyrieUtil {

    /**
     * Convert a hex string to an integer.
     * 
     * @param str
     * @return
     */
    public static int hexStringToInt(String str) {
        if (str.length() == 8) {
            int firstBit = Integer.valueOf(str.substring(0, 1), 16);

            if (firstBit >= 8) {
                return Integer.valueOf((firstBit - 8) + str.substring(1), 16) - 0x80000000;
            } else {
                return Integer.valueOf(str, 16);
            }
        } else {
            return Integer.valueOf(str, 16);
        }
    }

    public static String hexStringToASCIIString(String hexString) {
        StringBuffer sb = new StringBuffer(hexString.length() / 2);

        for (int i = 0; i < hexString.length(); i += 2) {
            sb.append((char) Integer.parseInt(hexString.substring(i, i + 2), 16));
        }

        return sb.toString();
    }

    /**
     * Convert byte array to hex string.
     * 
     * @param b the byte array to convert
     * @return the hex string converted
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);

        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;

            if (v < 16) {
                sb.append('0');
            }

            sb.append(Integer.toHexString(v));
        }

        return sb.toString().toUpperCase();
    }

    /**
     * Convert the class name that representing in a class file to one that representing in a source file in batch.
     * 
     * @param str The string representing classes in class file.
     * @return An array of strings that each of them representing a class in source file.
     */
    public static List<String> getTypes(String str) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < str.length();) {
            String type = searchType(str.substring(i));
            i += type.length();
            result.add(getType(type));
        }

        return result;
    }

    /**
     * Convert the class name that representing in a class file to one that representing in a source file.
     * 
     * @param str The string representing a class in class file.
     * @return The string representing a class in source file.
     */
    public static String getType(String str) {
        if (str.equals("V")) {
            return "void";
        } else if (str.equals("B")) {
            return "byte";
        } else if (str.equals("C")) {
            return "char";
        } else if (str.equals("D")) {
            return "double";
        } else if (str.equals("F")) {
            return "float";
        } else if (str.equals("I")) {
            return "int";
        } else if (str.equals("J")) {
            return "long";
        } else if (str.equals("S")) {
            return "short";
        } else if (str.equals("Z")) {
            return "boolean";
        } else if (str.startsWith("L")) {
            return str.substring(1, str.length() - 1).replace('/', '.');
        } else if (str.startsWith("[")) {
            return getType(str.substring(1)) + "[]";
        }

        return null;
    }

    public static String accessFlagsToString(List<AccessFlags> accessFlags, boolean isClass) {
        StringBuffer sb = new StringBuffer();

        if (accessFlags.contains(AccessFlags.ACC_PUBLIC)) {
            sb.append("public ");
        } else if (accessFlags.contains(AccessFlags.ACC_PROTECTED)) {
            sb.append("protected ");
        } else if (accessFlags.contains(AccessFlags.ACC_PRIVATE)) {
            sb.append("private ");
        }

        if (accessFlags.contains(AccessFlags.ACC_STATIC)) {
            sb.append("static ");
        }

        if (accessFlags.contains(AccessFlags.ACC_FINAL)) {
            sb.append("final ");
        }

        if (accessFlags.contains(AccessFlags.ACC_VOLATILE)) {
            sb.append("volatile ");
        }

        if (accessFlags.contains(AccessFlags.ACC_TRANSIENT)) {
            sb.append("transient ");
        }

        if (accessFlags.contains(AccessFlags.ACC_INTERFACE)) {
            sb.append("interface ");
        } else if (accessFlags.contains(AccessFlags.ACC_ENUM)) {
            sb.append("enum ");
        } else if (accessFlags.contains(AccessFlags.ACC_ABSTRACT)) {
            sb.append("abstract ");
        }

        if (isClass && !(accessFlags.contains(AccessFlags.ACC_INTERFACE) || accessFlags.contains(AccessFlags.ACC_ENUM))) {
            sb.append("class ");
        }

        return sb.toString();
    }

    private static String searchType(String str) {
        if (str.startsWith("L")) {
            return str.substring(0, str.indexOf(";") + 1);
        } else if (str.startsWith("[")) {
            return "[" + searchType(str.substring(1));
        } else {
            return str.substring(0, 1);
        }
    }
}
