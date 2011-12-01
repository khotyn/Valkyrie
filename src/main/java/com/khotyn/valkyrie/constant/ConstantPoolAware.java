package com.khotyn.valkyrie.constant;

import java.util.List;

public interface ConstantPoolAware {

    public void setConstantPool(List<ConstantPoolInfo> constantPoolInfos);

    public List<ConstantPoolInfo> getConstantPool();
}
