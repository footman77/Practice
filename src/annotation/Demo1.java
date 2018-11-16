package annotation;

import org.junit.Test;

/**
 * @author footman77
 * @create 2018-10-29 22:26
 */
public class Demo1 {

    @Test
    public void test01(){
        System.out.println(Demo1.class.getClassLoader().getClass());
    }
}
