package DynamicProgramming;

public class longestCommonSubstring {

    public static int longestCommonSubstring(String word1, String word2){

        int[][] size = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i < word1.length(); i++) size[i][0] = 0;
        for(int j = 0; j < word2.length(); j++) size[0][j] = 0;

        for(int i = 1; i < word1.length(); i++){
            for(int j = 1; j < word2.length(); j++){
                if( word1.charAt(i ) == word2.charAt(j)) size[i][j] = size[i - 1][j - 1] + 1;
                else size[i][j] = Math.max(size[i - 1][j], size[i][j-1]);
            }
        }

        for(int i = 0; i < word1.length(); i++){
            for(int j = 0; j < word2.length(); j++){
                System.out.print(size[i][j] + " ");
            }
            System.out.println();
        }

        return size[word1.length() - 1][word2.length() - 1];
    }

    public static void main(String[] args){
        String word1 = "abab";
        String word2 = " abca";

        System.out.println("Size of longest common substring = "+ longestCommonSubstring(word1,word2));
    }
}
