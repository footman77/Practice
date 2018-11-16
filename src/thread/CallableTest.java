package thread;

import java.util.concurrent.Callable;

/**
 * @author footman77
 * @create 2018-10-31 16:37
 */
public class CallableTest implements Callable {
    @Override
    public String call() throws Exception {
        return "test context";
    }
}
