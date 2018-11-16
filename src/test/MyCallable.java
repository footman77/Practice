package test;

import java.util.concurrent.Callable;

/**
 * @author footman77
 * @create 2018-10-11 0:48
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "nihaoa!!";
    }
}
