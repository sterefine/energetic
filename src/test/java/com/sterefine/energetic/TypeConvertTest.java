package com.sterefine.energetic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: doudai
 * 2020/7/22
 */
public class TypeConvertTest {
    @Test
    public void integerTest() {
        Integer x = Integer.valueOf(" 1 ");
        System.out.println(x);
        Assert.assertEquals(x.intValue(), 1);
    }
}
