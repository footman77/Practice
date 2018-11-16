package java8.exercise;

import java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author footman77
 * @create 2018-10-26 16:26
 */
public class TestLambda {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test01(){
        Collections.sort(emps,(e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });


        for(Employee emp : emps){
            System.out.println(emp);
        }
    }

    @Test
    public void test02(){
        String str = "adbsdsaf";
        String s = strHandler(str, (x) -> x.toUpperCase());
        System.out.println(s);

        String s1 = strHandler(str, (x) -> x.substring(1, 3));
        System.out.println(s1);
    }

    //处理字符串方法
    public String strHandler(String str ,MyFunction myFunction){
        return myFunction.getValue(str);
    }



    @Test
    public void test03(){
        op(100L,234L,(x,y) -> x + y);
    }


    //对于两个long型处理方法
    public void op(Long l1 ,Long l2,MyFunction2<Long,Long> myFunction2){
        System.out.println(myFunction2.getValue(l1,l2));

    }

}
