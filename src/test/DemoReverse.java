package test;

import org.junit.Test;

/**
 * @author kokio
 * @create 2018-12-27 21:35
 */
public class DemoReverse {

    @Test
    public void testReverse(){
        getReverse(1325);
    }

    public void getReverse(int n){
        StringBuilder res = new StringBuilder();
        String s = String.valueOf(n);
        String[] str = s.split("");
        String[] strReverse = new String[str.length];
        for(int i = 0; i < str.length; i++){
            strReverse[str.length - 1 - i] = str[i];
        }
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            int num1 = Integer.parseInt(str[i]);
            int num2 = Integer.parseInt(strReverse[i]);

            int sum = num1 + num2 + carry;
            if(sum >= 10){

                res.append(sum % 10);
                carry = 1;
            }else {
                res.append(sum);
                carry = 0;
            }
        }
        System.out.println(res.reverse().toString());
//
    }
}
