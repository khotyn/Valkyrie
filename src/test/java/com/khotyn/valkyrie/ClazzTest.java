package com.khotyn.valkyrie;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

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
        try {
            System.out.println(Arrays.toString(FileUtils.readFileToByteArray(new File("/Users/apple/Desktop/Main.class"))));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
