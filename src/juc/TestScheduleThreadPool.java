package juc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author kokio
 * @create 2018-12-25 1:55
 */
public class TestScheduleThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool =
                Executors.newScheduledThreadPool(6);


        for(int i = 0; i < 10; i++){
            ScheduledFuture<Integer> future = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(190);
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    return num;
                }
            }, 1, TimeUnit.SECONDS);

            System.out.println(future.get());
        }

        pool.shutdown();



    }
}
