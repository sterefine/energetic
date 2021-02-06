package com.sterefine.energetic.standalone;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

/**
 * @author: sterefine
 * Test Share Thread data
 */
public class AlgorithmApplication {
    @SneakyThrows
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        int index = binarySearch( array, 1);
        System.out.println(index);

        array = new int[]{2,1,3,4,5,9,7,8,6};
//        bubbleSort(array);
        insertSort(array);
        Arrays.stream(array).forEach(e -> System.out.print(e));
    }

    public static int binarySearch(int []array,int e){
        int low=0;
        int high=array.length-1;
        int mid;
        while( low <= high ){
            mid = (low + high) /2;
            if(array[mid] == e){
                return mid;
            }else if(array[mid] < e){
                low = mid + 1;
            }else{
                high= mid - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int []array ) {
        for( int i = 0 ; i < array.length; i++ ) {
            for(int j = 0; j < array.length - i - 1 ; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void insertSort(int []array ) {
        for(int i = 1 ; i < array.length; i++ ) {
            for(int j = 0 ; j < i ; j++) {
                if(array[j] > array[i]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private static void swap( int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

