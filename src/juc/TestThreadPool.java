package juc;

import thread.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author kokio
 * @create 2018-12-25 1:33
 * 线程池的体系结构：
 *   	java.util.concurrent.Executor : 负责线程的使用与调度的根接口
 *  		|--**ExecutorService 子接口: 线程池的主要接口
 *  			|--ThreadPoolExecutor 线程池的实现类
 *   			|--ScheduledExecutorService 子接口：负责线程的调度
 *  				|--ScheduledThreadPoolExecutor ：继承 ThreadPoolExecutor， 实现 ScheduledExecutorService
 *
 *  工具类 : Executors
 *  ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 *  ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
 *  ExecutorService newSingleThreadExecutor() : 创建单个线程池。线程池中只有一个线程
 *
 *  ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程，可以延迟或定时的执行任务。
 */
public class TestThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Future<Integer>> futures = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            Future<Integer> future = pool.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 1; i <= 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });


            futures.add(future);
        }


        for(Future<Integer> future : futures){
            System.out.println(future.get());
        }


//        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

//        //为线程池中的线程分配任务
//        for(int i = 0; i < 10; i++){
//            pool.submit(threadPoolDemo);
//
//        }

        //关闭线程池
        pool.shutdown();
//        pool.shutdownNow()//立即关闭
    }
}

class ThreadPoolDemo implements Runnable {

    private int i = 10;

    @Override
    public void run() {
        while (i <= 100){
            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }
}


