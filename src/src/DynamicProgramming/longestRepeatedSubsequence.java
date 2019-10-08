package DynamicProgramming;

import java.util.HashSet;

public class longestRepeatedSubsequence {

    /***
     * time: O(N)
     * space: O(N)
     * @param a
     * @return
     */
    public static int longestRepeatSub(String a){
        int[][] check = new int[a.length() + 1][a.length() + 1];
        HashSet<Character> hs = new HashSet<>();
        int tempi = 0, tempj = 0;

        for(int i = 0; i < a.length() + 1; i++) check[i][0] = 0;
        for(int j = 0; j < a.length() + 1; j++) check[0][j] = 0;


        for(int i = 1; i < a.length()  + 1; i++){
            for(int j = 1; j < a.length()  +  1; j++){
                if(a.charAt(i - 1) == a.charAt(j - 1) && i != j){
                    if(hs.contains(a.charAt(i - 1))) check[i][j] = check[tempi][tempj];
                    else{
                        hs.add(a.charAt(i - 1));
                        check[i][j] = check[tempi][tempj] + 1;
                        tempi = i;
                        tempj = j;
                    }
                }else check[i][j] = Math.max(check[i][j - 1], check[i - 1][j]);
            }
        }

        return check[a.length()][a.length()];
    }

    public static void main(String[] args){
        String a = "ATACTCGGALLLHH";
        System.out.println("size of longest repeated subsequence is " + longestRepeatSub(a));
    }
}
