package com.khotyn.valkyrie.parser;

import com.khotyn.valkyrie.*;
import com.khotyn.valkyrie.exception.IllegalClassException;
import com.khotyn.valkyrie.util.ValkyrieUtil;

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

        return clazz;
    }

    private void parseVersion(Clazz clazz, String byteString) {
        clazz.setMinorVersion(Integer.parseInt(byteString.substring(cursor, cursor += 4), 16));
        clazz.setMajorVersion(Integer.parseInt(byteString.substring(cursor, cursor += 4), 16));
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
