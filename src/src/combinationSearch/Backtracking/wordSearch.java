package combinationSearch.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class wordSearch {

    // store the result
    static HashSet<String> resultHs = new HashSet<>();
    static HashSet<String> hs;
    static HashSet<String> checkPrefix;

    // time: O(m*n) with m*n is the size of the board
    // space:O(m*n) is the size of visited array
    public static List<String> findWords(char[][] board, String[] words) {
        // add all the word in the substring
        hs = new HashSet<>(Arrays.asList(words));
        checkPrefix = new HashSet<>();

        // all all the prefix and the substring in the checkPrefix
        for(String w: words){
            String temp = new String();
            for(int i = 0; i < w.length();i++){
                temp += w.charAt(i);
                checkPrefix.add(temp);
            }
        }
        // traverse through the board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++) findWords(board,words,"",i,j);
        }

        List<String> result = new ArrayList<>(resultHs);
        return result;
    }

    public static void findWords(char[][] board, String[] word,String prefix, int row,int col)
    {
        // check for the location boundary
        if((row >= board.length || row < 0) || (col >= board[0].length || col < 0)) return;
            // check for visited already
        else if(board[row][col] == '8') return;
            // check for if the prefix exists in the dictionary
        else if(!checkPrefix.contains(prefix) && prefix.length() > 0) return;

        // marked as visit
        char temp = board[row][col];
        board[row][col] = '8';
        prefix += temp;
        if(hs.contains(prefix)) resultHs.add(prefix);


        // check the row up and down
        findWords(board,word,prefix,row-1,col);
        findWords(board,word,prefix,row+1,col);
        // check the column front and back
        findWords(board,word,prefix,row,col-1);
        findWords(board,word,prefix,row,col+1);

        //clean up for new search
        board[row][col] = temp;
    }

    public static void main(String[] args){
        char[][] board =    {{'b','a','a','b','a','b'},
                            {'a','b','a','a','a','a'},
                            {'a','b','a','a','a','b'},
                            {'a','b','a','b','b','a'},
                            {'a','a','b','b','a','b'},
                            {'a','a','b','b','a','a'},
                            {'a','a','b','a','a','b'}};
        String[] word =  {"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};
        System.out.println("All the word in the board found in the dictionary is ");
       for(String wo: findWords(board,word)) System.out.println(wo);
    }
}
