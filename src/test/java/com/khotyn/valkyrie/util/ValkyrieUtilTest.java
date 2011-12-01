package com.khotyn.valkyrie.util;

import org.junit.Assert;
import org.junit.Test;

public class ValkyrieUtilTest {

    @Test
    public void testGetTypeByte() {
        Assert.assertTrue("byte".equals(ValkyrieUtil.getType("B")));
    }

    @Test
    public void testGetTypeChar() {
        Assert.assertTrue("char".equals(ValkyrieUtil.getType("C")));
    }

    @Test
    public void testGetTypeDouble() {
        Assert.assertTrue("double".equals(ValkyrieUtil.getType("D")));
    }

    @Test
    public void testGetTypeFloat() {
        Assert.assertTrue("float".equals(ValkyrieUtil.getType("F")));
    }

    @Test
    public void testGetTypeInt() {
        Assert.assertTrue("int".equals(ValkyrieUtil.getType("I")));
    }

    @Test
    public void testGetTypeLong() {
        Assert.assertTrue("long".equals(ValkyrieUtil.getType("J")));
    }

    @Test
    public void testGetTypeShort() {
        Assert.assertTrue("short".equals(ValkyrieUtil.getType("S")));
    }

    @Test
    public void testGetTypeBoolean() {
        Assert.assertTrue("boolean".equals(ValkyrieUtil.getType("Z")));
    }

    @Test
    public void testGetTypeClass() {
        Assert.assertTrue("java.lang.String".equals(ValkyrieUtil.getType("Ljava/lang/String;")));
    }

    @Test
    public void testGetTypeArray() {
        Assert.assertTrue("java.lang.String[]".equals(ValkyrieUtil.getType("[Ljava/lang/String;")));
    }

    @Test
    public void testGetTypes() {
        System.out.println(ValkyrieUtil.getTypes("[ILjava/lang/String;"));
    }
}
