package com.khotyn.valkyrie;

/**
 * TODO: TypeTags.java
 * 
 * @author khotyn 2011-11-23 上午10:36:59
 */
public enum TypeTags {
    BYTE('B'), CHAR('C'), DOUBLE('D'), FLOAT('F'), INT('I'), LONG('J'), SHORT('S'), BOOLEAN('Z'), STRING('s'), ENUM('e'), CLASS('c'), ANNOTATION('@'), ARRAY(
            '[');

    public char tag;

    TypeTags(char tag) {
        this.tag = tag;
    }

    public static TypeTags getTypeTags(char c) {
        for (TypeTags tags : TypeTags.values()) {
            if (tags.tag == c) {
                return tags;
            }
        }

        return null;
    }
}
