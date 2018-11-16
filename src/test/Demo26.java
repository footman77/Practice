package test;

/**
 * @author footman77
 * @create 2018-10-21 12:03
 */

class Student{

    String name ; // 非静态的成员变量

    static	String country = "中国";  //静态的成员变量

    //静态代码块
    static{
        System.out.println("静态代码块的代码执行了..");
    }

    public Student(String name){
        this.name = name;
    }

    //静态函数
    public static void sleep(){
        System.out.println( "今晚早睡..");

    }


    //非静态函数
    public void study(){
        System.out.println(name+"好好学习，为将来可以成为高富帅做准备!!");
    }

}
public class Demo26 {
    public static void main(String[] args)
    {

        Student s1 = new Student("狗娃");
        Student s2 = new Student("铁蛋");
        System.out.println("姓名："+ s1.name);
        System.out.println("姓名："+ s2.name);
		/*
		System.out.println("国籍："+ Student.country);
		*/
    }
}

