package com.khotyn.valkyrie.util;

/**
 * User: apple
 * Date: 11-11-18
 * Time: AM10:39
 * Dust to dust, earth to earth.
 */
public class ValkyrieUtil {

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
}
