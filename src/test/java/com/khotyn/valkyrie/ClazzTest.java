package com.khotyn.valkyrie;

import com.khotyn.valkyrie.exception.IllegalClassException;
import com.khotyn.valkyrie.parser.ClassParser;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * User: apple
 * Date: 11-11-18
 * Time: AM12:14
 * Dust to dust, earth to earth.
 */
public class ClazzTest {
    @Test
    public void testReadClass() {
        ClassParser classParser = ClassParser.getInstance();
        try {
            Clazz clazz = classParser.parse(FileUtils.readFileToByteArray(new File("/Users/apple/Desktop/Main.class")));
            System.out.println(clazz.toString());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalClassException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
