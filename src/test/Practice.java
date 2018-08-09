package test;

public class Practice {
    public static void main(String[] args){
//        mulTab(7);
//        String str = isLeapYear(1996);
//        System.out.println(str);
//            int[] arr = {21, 2, 54, 111, 90};
//            int maxNum = getMaxNum(arr);
//            System.out.println(maxNum);
        Calculator test = new Calculator();
        test.setOperateOne(10);
        test.setOperateTwo(2);
        test.setSymbol('-');
        test.operation();
    }

//    public static void mulTab(int num){
//        for(int i = 1; i <= num; i++){
//            for(int j = 1; j <= i; j++){
//                System.out.print(i + "*" + j + "=" + i * j + " " );
//            }
//            System.out.println(" ");
//        }
//    }
//
//
//    public static String  isLeapYear(int inputYear){
//        String str = "非闰年";
//        if(inputYear % 400 == 0 || (inputYear % 100 != 0 && inputYear % 4 == 0)){
//            str = "闰年";
//        }
//        return str;
//
//    }
//
//    public static int getMaxNum(int[] arr){
//        int maxNum = arr[0];
//
//        for(int i = 1; i < arr.length; i++){
//            if(arr[i] > maxNum){
//                maxNum = arr[i];
//            }
//        }
//            return maxNum;
//
//    }


}

class Calculator{
    //操作数1
    private int operateOne;
    //操作数2
    private int operateTwo;
    //符号
    private char symbol;

    public void setOperateOne(int num){
        operateOne = num;
    }

    public void setOperateTwo(int num){
        operateTwo = num;
    }

    public void setSymbol(char cha){
        symbol = cha;
    }
    public void operation(){
        int res = 0;
        switch(symbol){
            case '+':
                res = operateOne + operateTwo;
                break;
            case '-':
                res = operateOne - operateTwo;
                break;
            case '*':
                res = operateOne * operateTwo;
                break;
            case '/':
                res = operateOne / operateTwo;
                break;
            default:
                System.out.println("无效");
                break;
        }
        System.out.println(res);
    }
}
