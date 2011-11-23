package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple Date: 11-11-18 Time: AM11:34 Dust to dust, earth to earth.
 */
public class ConstantUTF8 extends ConstantPoolInfo {

    public int     tag = CONSTANT_UTF8;

    private String content;

    public ConstantUTF8(String content){
        this.content = content;
    }

    public String toString() {
        return "UTF8{content:" + content + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConstantUTF8) {
            ConstantUTF8 constantUTF8 = (ConstantUTF8) obj;
            return content.equals(constantUTF8.content);
        }

        return false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
