package com.sterefine.energetic;
import com.google.common.collect.Lists;
import org.junit.Test;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: doudai
 */
public class StreamingTest {
    @Test
    public void peakTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        List<Integer> list2 = Lists.newArrayList();
        List<Integer> list3 = Lists.newArrayList();
        list.stream()
                .peek(o -> list2.add(o + 10))
                .map(o -> o + 1)
                .peek(o -> list3.add(o))
                .peek(System.out::println)
                .collect(Collectors.toList());
        list2.stream().forEach(System.out::println);
    }

    @Test
    public void groupByTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 2, 4, 5);

        Map<Integer, Long> map =
            list.stream()
            .collect( Collectors.groupingBy(Function.identity(), Collectors.counting() ));
        System.out.println(map);

        Map<Integer, Integer> map2 =
        list.stream()
                .collect( Collectors.groupingBy(Function.identity(), Collectors.summingInt( o -> o ) ));
        System.out.println(map2);

        Map<Integer, List<Integer>> map3 =
                list.stream()
                        .collect( Collectors.groupingBy(Function.identity()));
        System.out.println(map3);

        Map<Integer, Set<Integer>> map4 =
                list.stream()
                        .collect( Collectors.groupingBy(Function.identity(),
                                  Collectors.mapping( Function.identity(), Collectors.toSet())
                        ));
        System.out.println(map4);

        Map<Integer, Set<String>> map5 =
                list.stream()
                        .collect( Collectors.groupingBy(Function.identity(),
                                Collectors.mapping( e -> e.toString(), Collectors.toSet() )
                        ));
        System.out.println(map5);

        Map<Integer, Map<String, Integer>> map6 =
                list.stream()
                        .collect( Collectors.groupingBy(Function.identity(),
                                Collectors.toMap( e -> e.toString(),
                                        Function.identity(), (o1,o2) -> o1)
                        ));
        System.out.println(map6);

        Map<Integer, Map<String, Integer>> map7 =
                list.stream()
                        .collect( Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                                Collectors.toMap( e -> e.toString(),
                                        Function.identity(), (o1,o2) -> o1)
                        ));
        System.out.println(map7);
    }

    @Test
    public void reduceTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);

        int sum =list.stream()
                .map(o -> o + 1)
                .reduce(0, Integer::sum);

        System.out.println(sum);

        List<Integer> list2 =list.stream()
                .map(o -> o + 1)
                .reduce(new ArrayList<>(),
                        (List<Integer>l, Integer o) -> {l.add(o); return l;},
                        (List<Integer> l1, List<Integer> l2) -> {l1.addAll(l2);return l1;});

        System.out.println(list2);
    }

    @Test
    public void joiningTest() {
        List<String> list = Lists.newArrayList("Apple", "Banana","Pair");
        String totalString = list.stream().collect(Collectors.joining(","));
        System.out.println(totalString);
    }
}
