package com.khotyn.valkyrie;

/**
 * AccessFlags
 * 
 * @author khotyn 2011-11-17 обнГ5:01:42
 */
public enum AccessFlag {
    ACC_PUBLIC(0x0001), ACC_FINAL(0x0010), ACC_SUPER(0x0020), ACC_INTERFACE(0x0200), ACC_ABSTRACT(0x0400),
    ACC_SYNTHETIC(0x1000);

    public int flag;

    AccessFlag(int flag){
        this.flag = flag;
    }

}
