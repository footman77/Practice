package thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author footman77
 * @create 2018-10-11 17:15
 */
//public class EnterCallable implements Callable<int[]> {
//
//    int sum = 100;
//    int i = 1;
//    int count1 = 0;//前门
//    int count2 = 0;//后门
//    int[] arr = new int[2];
//    @Override
//    public int[] call() throws Exception {
//        while (true){
//            synchronized (EnterCallable.class){
//                if(i <= 100){
//                    if(Thread.currentThread().getName().equals("前门")){
//                        System.out.println("员工编号" + (i++) + "从" + Thread.currentThread().getName() + "入场! 拿到的双色球彩票号码是:" + Arrays.toString(getNum()) );
//                        count1++;
//                    }else {
//                        System.out.println("员工编号" + (i++) + "从" + Thread.currentThread().getName() + "入场! 拿到的双色球彩票号码是:" + Arrays.toString(getNum()) );
//                        count2++;
//                    }
//                    if(i == 100){
//                        System.out.println("");
//                    }
//                }
//
//            }
//
//        }
////        arr[0] = count1;
////        arr[1] = count2;
////        return arr;
//    }
//
//
//    public String[] getNum(){
//        String element;
//        Random random = new Random();
//        String[] arr = new String[7];
//        int j = 0;
//        int i = 0;
//        while (j < 7){
//            i = random.nextInt(33);
//            if(i < 10){
//                element = "0" + i;
//            }else {
//                element = "" + i;
//            }
//            arr[j] = element;
//            j++;
//        }
//
//        return arr;
//    }
//}
