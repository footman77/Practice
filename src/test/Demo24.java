package test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author footman77
 * @create 2018-10-11 16:37
 */
public class Demo24 {
    public static void main(String[] args) {

//        Random random = new Random();
//        int i = random.nextInt(2);
//        System.out.println(i);

        String[] num = getNum();
        System.out.println(Arrays.toString(num));

    }

    public static String[] getNum(){
        String element;
        Random random = new Random();
        String[] arr = new String[7];
        int j = 0;
        int i = 0;
        while (j < 7){
            i = random.nextInt(33);
            if(i < 10){
                element = "0" + i;
            }else {
                element = "" + i;
            }
            arr[j] = element;
            j++;
        }

        return arr;
    }
}
