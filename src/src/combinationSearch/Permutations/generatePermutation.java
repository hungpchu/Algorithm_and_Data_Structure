package combinationSearch.Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class generatePermutation {
    public static List<String> result;
    public static HashSet<String> hs, hsPrefix;
    public static boolean validParen(char[] paren){
        if(paren.length == 0) return true;
        Stack<Character> openBra = new Stack<>();
        int i = 0;
        while(i < paren.length){
            char element = paren[i];
            if(element == '(') openBra.add(element);
            else{
                if(openBra.isEmpty()) return false;
                else  openBra.pop();
            }
            i++;
        }
        if(openBra.size() > 0) return false;
        return true;
    }

    public static void exchange(char[] paren, int current, int start){
        char temp = paren[start];
        paren[start] = paren[current];
        paren[current] = temp;
    }

    public static void permutation(char[] paren, int start){
        if(hs.contains(new String(paren)) ) return;
        if(start == paren.length){
            if(validParen(paren)){
                System.out.println(new String(paren));
                hs.add(new String(paren));
            }
            return;
        }
        hsPrefix.add(new String(paren));
        for(int current = start; current < paren.length;current++){
            // exchange current to start index
            exchange(paren, current, start);
            // permu all (start+1)!
            permutation(paren, start+1);
            // put back after exchange
            exchange(paren, current, start);
        }
        hsPrefix.remove(new String(paren));
    }

    public static List<String> generateParenthesis(int n) {
        if( n == 0) return new ArrayList<>();
        hs = new HashSet<>();
        hsPrefix = new HashSet<>();
        char[] paren = new char[n*2];
        for(int i = 0; i < paren.length;i++){
            if(i % 2 == 0) paren[i] = '(';
            else paren[i] = ')';
        }
        permutation(paren,0);
        result = new ArrayList<>(hs);
        return result;
    }

    public static void pem(String pre, int open, int end, int N){
        if(pre.length() == N * 2){
             System.out.println(pre);
            return;
        }
        if(open+1 <= N && end<=open) pem(pre+'(',open+1,end,N);
       // System.out.println("pre = " + pre + " open = " + open + " end = "+ end);
        if(end<=open && open > 0) pem(pre+')',open,end+1,N);

    }

    public static void main(String[] args){
//        generateParenthesis(6);
        pem("",0,0,3);
    }
}
