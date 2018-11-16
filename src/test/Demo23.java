package test;

/**
 * @author footman77
 * @create 2018-10-10 22:50
 */
public class Demo23 {
    public static void main(String[] args) {

        Demo22 demo22 = new Demo22();
        demo22.start();

        for(int i = 0 ; i < 10; i++){
            System.out.println("主" + i);
        }
    }
}
