package test;

/**
 * @author footman77
 * @create 2018-10-10 22:49
 */
public class Demo22 extends Thread {
    @Override
    public void run() {
        for(int i = 0 ; i < 10; i++){
            System.out.println(i);
        }
    }
}
