package Recursion;

public class Fibonacci {

    public static int time;

    public static int fibonacci(int n){
        if( n == 0 ) return 0;
        if(n == 1) return 1;
        time ++;
        int lessOneN = fibonacci(n - 1);
        int lessTwoN = fibonacci(n - 2);
        return lessOneN + lessTwoN;
    }

    /***
     * Time: O(N) with the value of N
     * Space:O(1) with no array
     */
    public static long fiboMem(int N){
        if(N == 0) return 0;
        if(N == 1) return 1;
        long lessOne = 0;
        long lessTwo = 1;
        long result = 0;
        for(int i = 2; i <= N;i++){
              result = lessOne + lessTwo;
              lessOne = lessTwo;
              lessTwo = result;
        }
        return result;
    }

    public static void main(String[] args){
        time = 0;
        System.out.println("fibo of 2 = " + fibonacci(20));
        System.out.println("time running = "+ time);
        System.out.println("fibo memor of 2 = "+ fiboMem(100));

    }
}
