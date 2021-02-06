package com.sterefine.energetic;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author: doudai
 * 2020/7/7
 */
public class CollectionRemveRangeTest {
    @Test
    public void removeRangeTest(){
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list2 = Lists.newArrayList();
        list2.addAll(list.subList(0,5));
        list.subList(0,5).clear();
        list.forEach(System.out::print);
        System.out.println();
        list2.forEach(System.out::print);
    }
}
