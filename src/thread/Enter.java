package thread;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;

/**
 * @author footman77
 * @create 2018-10-11 16:51
 */
public class Enter implements Runnable {

    int sum = 100;
    int i = 1;
    int count1 = 0;//前门
    int count2 = 0;//后门
    @Override
    public void run() {

        while (true){
            synchronized (Enter.class){
                if(i <= 100){
                    if(Thread.currentThread().getName().equals("前门")){
                        System.out.println("员工编号" + (i++) + "从" + Thread.currentThread().getName() + "入场! 拿到的双色球彩票号码是:" + Arrays.toString(getNum()) );
                        count1++;
                    }else {
                        System.out.println("员工编号" + (i++) + "从" + Thread.currentThread().getName() + "入场! 拿到的双色球彩票号码是:" + Arrays.toString(getNum()) );
                        count2++;
                    }
                }
                if(count2 + count1 == 100){

//                        Thread.sleep(100);
                        System.out.println("前门入场" + count1 + "后门入场" + count2);
                        count1 = 0;
                        count2 = 0;


                }

            }

        }
    }


    public String[] getNum(){
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
