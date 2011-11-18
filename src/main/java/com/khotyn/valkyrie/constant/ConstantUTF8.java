package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-18
 * Time: AM11:34
 * Dust to dust, earth to earth.
 */
public class ConstantUTF8 extends ConstantPoolInfo {
    public int tag = CONSTANT_UTF8;
    public String content;

    public String toString() {
        return "UTF8{content:" + content + "}";
    }
}
