package DynamicProgramming;

/***
 * Link: https://leetcode.com/problems/edit-distance/
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * Problem construct = sequence alignment with insert gap and align the longest subsequence between 2 strings
 * Example: horse and ros
 * -orse
 * ro-s-
 * -> replace h with - and insert - in to ros so that line up o and s between 2 strings
 * -> min edit number = 3
 * Time:O(mn)
 * Spaxe:O(mn)
 */
public class editDistance {

    public static int minDistance(String word1, String word2) {
        // with 1 space for gap
        int[][] editDistance = new int[word1.length()+1][word2.length()+1];
        // gap will match with gap
        editDistance[0][0] = 0;
        for(int i = 1; i <= word2.length();i++) editDistance[0][i] = editDistance[0][i-1] + 1;
        for(int j = 1;j <= word1.length();j++) editDistance[j][0] = editDistance[j-1][0] + 1;

        for(int i = 1;i <= word1.length(); i++){
            for(int j = 1; j <= word2.length();j++){
                // check the character between word1 and word2
                char charWord1 = word1.charAt(i-1);
                char charWord2 = word2.charAt(j-1);
                // check for minEditGap between vertical from the left and horizontal from up
                int minEditGap = Math.min(editDistance[i-1][j],editDistance[i][j-1]);
                // check minEditGap with (minMatch or minNotMatch) from diagonal
                int minEdit = Math.min(minEditGap,editDistance[i-1][j-1]);
                // if not match then plus 1 since we need to edit
                if(charWord1 != charWord2) editDistance[i][j] = minEdit + 1;
                // else not plus since we not need to edit
                else{
                    // if the minEdit come from the diagonal then we know that we
                    // have a match then we do not need to edit more
                    if(minEdit == editDistance[i -1][j - 1]) editDistance[i][j] = minEdit;
                    // if from vertical or horizontal then we have to add 1 more edit
                    else editDistance[i][j] = minEdit + 1;
                }
            }
        }
        // the end is the minimum edit so that we can line up the longest subsequence between 2 strings
        return editDistance[word1.length()][word2.length()];
    }

    public static void main(String[] args ){
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("The min edit between " + word1 + " and " + word2 + " is " + minDistance(word1,word2));
    }
}
