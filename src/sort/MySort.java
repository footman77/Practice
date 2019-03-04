package sort;

import java.util.Arrays;

public class MySort {

    public static void main(String[] args) {
        Integer[] arr = {12, 43, 2, 5, 21,9};
//        BubbleSort.mergeSort(arr,1,5);

        InsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void InsertSort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i ++){
            Comparable temp = arr[i + 1];
            int j = i + 1;
            for(; j > 0; j--){
                if(temp.compareTo(arr[j - 1]) < 0){
                    arr[j] = arr[j - 1];
                }else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }

}
