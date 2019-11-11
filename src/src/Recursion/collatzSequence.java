package Recursion;

public class collatzSequence {

    // O(N) with N is the input number
    public static void collatsSequence(int N){
        System.out.print(N + " ");
        if(N == 1) return;
        if(N % 2 == 0)  collatsSequence(N/2);
        else collatsSequence(3*N+1);
    }

    public static void main(String[] args){
        collatsSequence(11);
    }
}
