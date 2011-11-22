package com.khotyn.valkyrie;

public enum BytecodeBehavior {
    REF_GETFIELD(1), REF_GETSTATIC(2), REF_GETPUTFIELD(3), REF_PUTSTATIC(4), REF_INVOKEVIRTUAL(5), REF_INVOKESTATIC(6),
    REF_INVOKESPECIAL(7), REF_NEWINVOKESPECIAL(8), REF_INVOKEINTERFACE(9);

    public int value;

    BytecodeBehavior(int value){
        this.value = value;
    }

    public static BytecodeBehavior getInstance(int value) {
        for (BytecodeBehavior bb : BytecodeBehavior.values()) {
            if (bb.value == value) {
                return bb;
            }
        }

        return null;
    }
}
