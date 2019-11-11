package Recursion;

public class ruler {

    // create subdivision of ruler with to 1/2 inch
    // Time: O(logN) with N is the size of the ruler
    public static String ruler(int N){
        if(N == 0) return " ";
        String rulerHalf = ruler(N - 1);
        return rulerHalf + Integer.toString(N) + rulerHalf;
    }

    public static void main(String[] args){
        System.out.println("Ruler is " + ruler(4));
    }
}
