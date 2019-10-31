package Math;

import java.util.HashMap;

public class power {

    public static double myPow(double x, int n){
        if(n < 0){
            return 1/myPowCalculate(x,n);
        }else return myPowCalculate(x,n);
    }


    /***
     * Time: O(logN)
     * Space:O(logN) since we use recursive to put in the stack of memory
     */
    public static double myPowCalculate(double x, int n) {
        if(n == 0) return 1.0;
        double halfPow = myPowCalculate(x,n/2);
        if(n%2== 0){
            return halfPow*halfPow;
        }
        else return x * halfPow*halfPow;
    }


    public static void main(String[] args){
        System.out.println("my pow = "+ myPow(2.00000, 10));
    }
}
