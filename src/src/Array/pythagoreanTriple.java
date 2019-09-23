package Array;

import java.util.Arrays;

public class pythagoreanTriple {

    public static boolean pythagoreanCheck(int[] a){
        int i = 0;
        int k = i + 1;
        int j = a.length - 1;
        while(i < a.length - 1){
            if(k == j || j < 0 || k > a.length - 1){
                i++;
                k = i + 1;
                j = a.length -1;
            }else {
                if (Math.pow(a[i], 2) + Math.pow(a[k], 2) == Math.pow(a[j], 2)) return true;
                else if (Math.pow(a[i], 2) + Math.pow(a[k], 2) < Math.pow(a[j], 2)) j--;
                else k++;
            }

        }
        return false;
    }

    public static void main(String[] args){
        int[] a =   {10, 4, 6, 12, 5};
        Arrays.sort(a);
        System.out.println(pythagoreanCheck(a));
    }
}
