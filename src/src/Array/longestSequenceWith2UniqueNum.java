package Array;

import java.util.HashSet;

public class longestSequenceWith2UniqueNum {

    public static int longestSubsequence(int[] arr){
        int start = 0;
        int end = start ;
        int min = 0;
        HashSet<Integer> hs = new HashSet<>();
        hs.add(arr[start]);
        while( start < arr.length ){
            if(hs.size() == 3){
                if( min < end - start) min = end - 1 - start;
                System.out.println("start = " + start + " end = " + (end - 1));
                start = end - 2;
                System.out.println("start sau = " + start + " end = " + (end - 1));
                hs = new HashSet<>();
                hs.add(arr[start]);
                hs.add(arr[start  + 1]);
            }

            if(end == arr.length){
                System.out.println("start trong = " + start + " end trong = " + (end - 1));
                if(min < end - start) min = end - start;
                break;
            }
                hs.add(arr[end]);
                end++;



        }



        return min;
    }

    public static void main(String[] args){
      int[] a = {3,1,3,4,3,1,3,3};
      System.out.println(longestSubsequence(a));
        String al = "1234";
        System.out.println(al.substring(2));
    }
}
