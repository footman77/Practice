package test;

class TakeMoney extends  Thread{

    static int money = 5000;

    public TakeMoney(String name){
        super(name);
    }

    @Override
    public void run() {
        while (true){
            synchronized("锁"){
                if(money > 0){
                    money -= 100;
                    System.out.println(Thread.currentThread().getName() + "取了100，还剩" + money);

                }else{
                    System.out.println("没钱了");
                    break;
                }
            }
        }

    }
}

public class Demo11 {
    public static void main(String[] args) {
        TakeMoney takeMoney = new TakeMoney("mother");
        TakeMoney takeMoney1 = new TakeMoney("father");

        takeMoney.start();
        takeMoney1.start();

    }
}
