package test;

public class Demo10 extends Thread{

    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("自定义" + i);
        }
    }

    public static void main(String[] args) {
        Demo10 d = new Demo10();
        d.start();
        for(int i = 0; i < 100; i++){
            System.out.println("主" + i );
        }
    }
}
