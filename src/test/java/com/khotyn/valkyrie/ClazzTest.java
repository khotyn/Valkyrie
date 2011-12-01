package com.khotyn.valkyrie;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.khotyn.valkyrie.exception.IllegalClassException;
import com.khotyn.valkyrie.parser.ClassParser;

/**
 * User: apple Date: 11-11-18 Time: AM12:14 Dust to dust, earth to earth.
 */
public class ClazzTest {

    @Test
    public void testReadClass() {

        try {
            ClassParser classParser = new ClassParser(
                                                      IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("Main.class")));
            Clazz clazz = classParser.parse();
            System.out.println(clazz.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalClassException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
