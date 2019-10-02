package DynamicProgramming;

public class longestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] size =  new int[text1.length() + 1][text2.length() + 1];

        for(int i = 0; i < text1.length() + 1; i++) size[i][0] = 0;
        for(int j = 0; j < text2.length() + 1; j++) size[0][j] = 0;

        for(int i = 1; i < text1.length() + 1; i++){
            for( int j = 1; j < text2.length() + 1; j++){
                if(text1.charAt(i -  1) == text2.charAt(j - 1)) size[i][j] = size[i - 1][j-1] + 1;
                else {
                    size[i][j] = Math.max(size[i][j - 1], size[i - 1][j]);
                }
            }
        }
        return size[text1.length()][text2.length()];

    }

    public static void main(String[] args){
        String text1 = "mzjawxu";
        String text2 = "jawxu";
        System.out.println(" size of longest common subsequence is " + longestCommonSubsequence(text1,text2));
    }
}
