package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author footman77
 * @create 2018-10-24 22:04
 *
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */
public class TestLambda3 {

    //function
    @Test
    public void test03(){
        String s = strHandler("     你好啊！！！！      ", (str) -> str.trim());
        System.out.println(s);
    }


    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }


    //supplier
    @Test
    public void test02(){

        List<Integer> values = getValues(10, () -> (int) (Math.random() * 100));
        for(Integer v : values){
            System.out.println(v);
        }

    }

    public List<Integer> getValues(int num, Supplier<Integer> supplier){
        List<Integer> lists = new ArrayList<>();

        for(int i =0; i < num ; i++){
            Integer integer = supplier.get();
            lists.add(integer);
        }
        return lists;

    }


    //Consumer
    @Test
    public void test01(){
        happy(100,(x) -> System.out.println("消费" + x) );
    }

    public void happy(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

}
