package Greedy;

public class minUniqueArraySum {

    public static int min(int[] a){
        if(a.length == 0) return -1;
        int sum = a[0];
        for(int i = 1; i < a.length;i++){
            if(a[i] <= a[i-1]) a[i] = a[i - 1] + 1;
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args){
//        int[] a = {1,1,1,2,2,2,3,3,4,4,4};
        int[] a = {2,2,3,4};
        System.out.println("min sum = " + min(a));
    }
}
