package thread;

import java.util.Random;

/**
 * @author footman77
 * @create 2018-10-11 16:30
 */
public class Lottery implements Runnable {

    int[] arr = {10,5,20,50,100,200,500};

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            int i = random.nextInt(arr.length );
            System.out.println(Thread.currentThread().getName() + "产生了" + arr[i] + "元大奖");
        }

    }
}
