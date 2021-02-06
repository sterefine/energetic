package com.sterefine.energetic;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

/**
 * @author: doudai
 * 2020/7/7
 */
public class HashEqualTest {

    @Test
    public void hashAndEqualTest(){
        P1 a = new P1(1,1);
        P1 b = new P1(1,1);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @Test
    public void hashAndEqualTest2(){
        P2 a = new P2(1,1);
        P2 b = new P2(1,1);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @Test
    public void hashAndEqualTest3(){
        P3 a = new P3(1,2, 3);
        P3 b = new P3(1,1, 3);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @Test
    public void hashAndEqualTest4(){
        P4 a = new P4(1,2, 3);
        P4 b = new P4(1,1, 3);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @Test
    public void hashAndEqualTest5(){
        P4 a = new P4(1,1, 3);
        P4 b = new P4(1,1, 3);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @AllArgsConstructor
    class P1 {
        public int x;
        public int y;
    }

    @AllArgsConstructor
    @EqualsAndHashCode
    @RequiredArgsConstructor
    class P2 {
        public int x;
        public int y;
    }

    @AllArgsConstructor
    @EqualsAndHashCode
    class P3 extends P2 {
        public int z;
        public P3(int x, int y, int z) {
            super(x, y);
            z = this.z;
        }
    }

    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    class P4 extends P2 {
        public int z;
        public P4(int x, int y, int z) {
            super(x, y);
            z = this.z;
        }
    }
}
