package sort;

import java.util.Arrays;

/**
 * @author kokio
 * @create 2018-12-28 11:09
 */
public class MergeSort {
    private MergeSort(){}


    private static void merge(Comparable[] arr,int l,int mid,int r){
        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        int i = l;
        int j = mid+1;
        for(int k = l; k <= r; k++){
            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }

    }


    public static void sort(Comparable[] arr,int l,int r){
        if(l >= r){
            return;
        }

        int mid = (r - l) / 2 + l;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }


    public static void main(String[] args) {
        Integer[] arr = {12,32,124,843,23,9};
        sort(arr,0,5);
        System.out.println(Arrays.toString(arr));
    }
}
