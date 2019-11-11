package Recursion;

public class Binary {

public static int count;
    // O(N) since we call the recursive call once even we store the value in the variable binaryHalf
    public static String Binary(int N){
        if(N == 1) return "1";
        else if (N == 0) return "0";
        count++;
        String binaryHalf = Binary(N/2);
        return binaryHalf + Integer.toString(N%2);
    }

    public static void main(String[] args){
        count = 0;
        System.out.println("Binary of 6 is " + Binary(256));
        System.out.println("time = "+ count);
    }
}
