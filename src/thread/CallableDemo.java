package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author footman77
 * @create 2018-10-31 16:38
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest callableTest = new CallableTest();
        FutureTask<String> futureTask = new FutureTask<String>(callableTest);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
