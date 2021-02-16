package com.sterefine.energetic.generic;

import lombok.Builder;

@Builder
public class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public static <T> Pair<T> build(T first, T last){
        return new Pair<>(first, last);
    }

    public static void print(Pair<?> pair) {
        String result = String.format("first %s, last %s",
                pair.getFirst().toString(), pair.getLast().toString() );
        System.out.println(result);
    }

    public static void printDouble(Pair<? extends Double> pair) {
        String result = String.format("first %f, last %f",
                pair.getFirst(), pair.getLast() );
        System.out.println(result);
    }
}
