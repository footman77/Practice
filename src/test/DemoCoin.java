package test;

import org.junit.Test;

import java.util.Stack;

/**
 * @author kokio
 * @create 2018-12-27 21:20
 */
public class DemoCoin {

    @Test
    public void testCoin(){
        getString(10);
    }


    public void getString(int n){
        Stack<String> stack = new Stack<>();
        StringBuffer buffer = new StringBuffer();
        Stack<String> string = getString(n, stack);
        while (!string.isEmpty()){
            buffer.append(string.pop());
        }
        System.out.println(buffer.toString());

    }

    private Stack<String> getString(int n,Stack<String> stack){
        if(n == 2){
            stack.push("2");
            return stack;
        }
        if(n == 1){
            stack.push("1");
            return stack;
        }

        if(n % 2 == 0){
            stack.push("2");
            n = (n - 2) / 2;
            getString(n,stack);
        }else {
            stack.push("1");
            n = (n - 1) / 2;
            getString(n,stack);
        }
        return stack;

    }
}
