package test;



public class Solution {
    /**
     * @param a: a positive integer
     * @return: the smallest positive integer whose multiplication of each digit equals to a
     */
    public static int smallestFactorization(int a) {
        // Write your code here
        long res = 0;
        long base = 1;
        for(int i = 9; i >= 2; i--){
            while (a % i == 0){
                a /= i;
                res += base * i;


                if(res > Integer.MAX_VALUE){
                    return 0;
                }

                base *= 10;
            }


        }
        return a != 1 ? 0 : (int)res;
    }

    public static void main(String[] args) {
        int i = smallestFactorization(48);
        System.out.println(i);
    }
}
