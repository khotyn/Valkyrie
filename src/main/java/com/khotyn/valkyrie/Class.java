package com.khotyn.valkyrie;

import java.util.List;

/**
 * A data structure representing the the java byte code
 * 
 * @author khotyn 2011-11-17 обнГ4:45:53
 */
public class Class {

    public static final String MAGIC_NUMBER = "0xCAFEBABE";
    private int                majorVersion;
    private int                minorVersion;
    private List<CPInfo>       cpInfos;
    private List<AccessFlag>   accessFlags;
    private String             thisClass;
    private String             superClass;
    private List<String>       interfaces;
    private List<String>       fields;
    private List<Method>       methods;
}
