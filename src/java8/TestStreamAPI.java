package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author footman77
 * @create 2018-10-25 15:00
 *
 * 一、Stream API 的操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI {

    //创建流
    @Test
    public void test01(){
//1. Collection 提供了两个方法  stream() 串行流 与 parallelStream() 并行流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法stream()获得数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(emps);


        //3. 通过 Stream 类中静态方法 of()
        Stream<String> stringStream = Stream.of("a", "fjsad", "fdhs");

        //4. 创建无限流
        //迭代
        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);

        integerStream.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .forEach(System.out::println);
    }
}
