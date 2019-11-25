package DynamicProgramming;


import java.util.HashMap;


public class longestCommonPalindrome {
    public static int LCP(String a, int i, int j){
        // base case when i bigger then j
        if(i > j) return 0;
        // if i = j then there is palin length = 1
        if(i == j) return 1;

        if(a.charAt(i) == a.charAt(j)) return 2 + LCP(a,i + 1, j - 1);

        return Math.max(LCP(a,i + 1,j), LCP(a,i,j-1));

    }

    /***
     * top down dynamic programming using hashmap to store result
     */
    public static int LCP_Dynamic(String a, int i, int j,  HashMap<String,Integer> hm ){
        // base case when i bigger then j
        if(i > j) return 0;
        // if i = j then there is palin length = 0
        if(i == j) return 1;

        if (!hm.containsKey(a)){
            if(a.charAt(i) == a.charAt(j)) hm.put(a,2+ LCP_Dynamic(a,i+1,j-1,hm));
            else hm.put(a,Math.max(LCP_Dynamic(a,i+1,j,hm), LCP_Dynamic(a,i,j-1,hm)));
        }


        return hm.get(a);

    }


    public static void main(String[] args){
        String a = " bbdcacbdgssssssssssssssssssssssssssssssssssgtwettttertewtertwe";
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        System.out.println("size of longest palindrome subsequence is " + LCP_Dynamic(a,0,a.length() - 1,hm));

    }
}
