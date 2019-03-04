package test;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author kokio
 * @create 2018-12-27 22:18
 */
public class DemoLongth {

    @Test
    public void testLongth(){
        getLongth("aaabbaaac");
    }

    public void getLongth(String str){
        int num = 0;
        float sum = 0;

        String[] strings = str.split("");

        int left = 0;
        int right = -1;
        int len = 0;
        while (right < strings.length - 1 ){

            if(strings[left].equals(strings[right + 1])){
                right = right + 1;
                len += 1;
            }else {
                sum += len;
                len = 0;
                num++;
                left = right + 1;

            }

        }
        sum += len;
        num ++;

//        double r = (double) sum/num;
//        System.out.println(sum);
//        System.out.println(num);
//
//        DecimalFormat df = new DecimalFormat("0.00");
////        int res = sum * 100/num;
//
//        String format = df.format(r);
//        System.out.println(format);
        System.out.println(sum/num);

    }
}
