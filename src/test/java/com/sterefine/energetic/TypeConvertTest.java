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

    @Test
    public void instanceTest() {
        String s = "bbbbb";
        Double d = 123D;
        System.out.println(s instanceof String);
        System.out.println(d instanceof Number);
        System.out.println(d instanceof Double);
    }


    class A{}
    class B extends A{}

    public class TestInstance<T> {
        private Class<T> t;
        public TestInstance(Class<T> t){
            this.t = t;
        }

        public boolean compare(Object obj){
            return t.isInstance(obj);
        }
    }

    @Test
    public void tempTest() {
        TestInstance<A> ti = new TestInstance<A>(A.class);
        System.out.println(ti.compare(new A()));
        System.out.println(ti.compare(new B()));
    }
}
