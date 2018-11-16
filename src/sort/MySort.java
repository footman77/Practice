package sort;

import java.util.Arrays;

public class MySort {

    public static void main(String[] args) {
        Integer[] arr = {12, 43, 2, 5, 21,9};
        BubbleSort.mergeSort(arr,1,5);
        System.out.println(Arrays.toString(arr));
    }



}
