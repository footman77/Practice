package java8;


import java8.Employee.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author footman77
 * @create 2018-10-26 22:52
 */
public class TestStreamAPI3 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VACATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );

    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test09(){
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("," , "----", "----"));

        System.out.println(str);
    }



    //分区
    @Test
    public void test08(){
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));
        Set<Map.Entry<Boolean, List<Employee>>> entries = map.entrySet();
        for(Map.Entry entry : entries){
            System.out.println(entry.getKey() + entry.getValue().toString());
        }

//        System.out.println(map);
    }




    //分组
    @Test
    public void test06(){
        Map<Status, List<Employee>> collect = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
    }

    //多级分组
    @Test
    public void test07(){
        Map<Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if(e.getAge() >= 60)
                        return "老年";
                    else if(e.getAge() >= 35)
                        return "中年";
                    else
                        return "成年";
                })));

        System.out.println(map);
    }


    @Test
    public void test05(){
        Long collect = emps.stream()
                .collect(Collectors.counting());
        System.out.println(collect);

        System.out.println("------------");

        //平均值
        Double collect1 = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect1);


        //总和
        emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        //最大值
        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));

        System.out.println(max.get());

        Optional<Employee> op = emps.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println(op.get());
    }

    @Test
    public void test04(){
        List<String> collect = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("-------------");

        Set<String> collect1 = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        collect1.forEach(System.out::println);

        System.out.println("--------");

        HashSet<String> collect2 = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

    }


    /*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    @Test
    public void test03(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> optional = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

    }



    //3. 终止操作
	/*
		allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值
		min——返回流中最小值
	 */

	@Test
    public void test02(){
        long count = emps.stream()
                .count();
        System.out.println(count);

        Optional<Employee> max = emps.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());

        Optional<Double> min = emps.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(min.get());
    }

	@Test
	public void test01(){
        boolean b = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b);
        boolean bl1 = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Status.BUSY));

        System.out.println(bl1);

        boolean bl2 = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Status.BUSY));

        System.out.println(bl2);

        Optional<Employee> first = emps.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        Employee employee = first.get();
        System.out.println(employee);

        Optional<Employee> employee1 = emps.stream()
                .filter((e) -> e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(employee1.get());
    }


}

