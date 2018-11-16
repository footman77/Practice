package test;

/**
 * @author footman77
 * @create 2018-11-08 13:15
 */
class Student1{

    String name; //姓名

    static String country = "中国";	// 成员变量使用了static修饰，那么该数据会进去方法区内存中，而且只会存在一份数据。

    static {
        System.out.println("静态代码块的内容执行了");
    }

    {
        System.out.println("代码块的呢哦日你哥执行了");
    }

    public Student1(String name){
        this.name = name;
        System.out.println("构造函数执行了");
    }


    public void study(){
        System.out.println("好好学习");
    }
}

public class Demo29 {
    public static void main(String[] args)
    {

        Student1 student1 = new Student1("小胖");
//
//        Student1 s1 = new Student1("张三");
//        Student1 s2 = new Student1("李四");
//
//        System.out.println("姓名："+ s1.name+" 国籍："+ s1.country); // 日本
//        s2.country = "日本";
//        System.out.println("姓名："+ s2.name+" 国籍："+ s2.country); // 中国

    }
}
