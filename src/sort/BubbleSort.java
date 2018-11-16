package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        Integer[] arr = {2,10,3,9,5};
//        selectSort(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        insertSort2(arr);
        //快排
//        querySort(arr,0,4);
//        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,4);
        System.out.println(Arrays.toString(arr));
    }

    //选择排序,每次将第一个拿出，与之后的进行比较 这是一种傻逼的方式，可以把第一个索引拿出来,
    // 然后和后面进行比较，如果条件成立，修改索引值，最后交换一次
    public static void selectSort(Integer[] arr){

        for(int i = 0; i < arr.length - 1; i++ ){
            for(int j = i + 1;j < arr.length;j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    //冒泡排序，从一开始，两两比较，选择大的（小的）往后移
    public static void bubbleSort(Integer[] arr){
        int tmp = 0;
        int size = arr.length;
        for(int i = 0; i < size - 1; i++ ){
            for(int j = 0; j < size - i -1; j++){
                if(arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(Integer[] arr){
        int tmp = 0;
        int size = arr.length;
        for(int i = 1; i < size; i++){

            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort2(Integer[] arr){

        int size = arr.length;
        for(int i = 1; i < size; i++){
            int temp = arr[i];
            int j;
            for(j = i - 1;j >= 0 && arr[j] > temp;j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;

        }
        System.out.println(Arrays.toString(arr));
    }





    public static void querySort(Integer[] arr,int i,int j){

        if(i < j){
            int middle = getMiddle(arr, i, j);
            querySort(arr,i,middle - 1);
            querySort(arr,middle + 1, j);
        }
    }





    /**
     *
     * @param arr 数组
     * @param i 数组开始的位置，下标
     * @param j 数组结束的位置，下标
     * @return
     */

    public static int getMiddle(Integer[] arr,int i,int j){

        while (i < j){
            while (i < j && arr[i] < arr[j]){
                j--;
            }
            if(i < j){//此时arr[i] > arr[j] 交换位置
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
            while (i < j && arr[i] < arr[j]){
                i++;
            }
            if(i < j){//此时arr[i] > arr[j]
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
        return j;

    }


    /**
     *
     * @param arr 需要合并的数组
     * @param first 合并数组的第一个下标
     * @param middle    中间下标
     * @param end   最后一个下标
     *
     */

    public static void mergeArray(Integer[] arr,int first,int middle,int end){

        Integer[] temp = new Integer[arr.length];
        int i = first;
        int j = middle + 1;
        int m = middle;
        int n = end;
        int k = 0;

        while (i <= m && j <= n){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m){
            temp[k++] = arr[i++];
        }
        while (j <= n){
            temp[k++] = arr[j++];
        }

        for(i = 0; i < k; i++){
            arr[first + i] = temp[i];
        }



    }

    public static void mergeSort(Integer[] arr,int first,int end){
//        if(first >= end){
//            return;
//        }
//
        int middle = (end + first)/2;

        if(end > first){
            mergeSort(arr,first,middle);
            mergeSort(arr,middle + 1,end);
            mergeArray(arr,first,middle,end);
        }
    }



}
