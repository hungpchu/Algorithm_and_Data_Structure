package DynamicProgramming;

public class factorial {
    public static int factorial(int n){
        int[] store = new int[100];
        store[0] = 1;
        for(int i = 1; i <= n; i++) store[i] = i * store[i - 1];
        return store[n];
    }

    public static void main(String[] args){
        System.out.println(factorial(20));
    }


}
