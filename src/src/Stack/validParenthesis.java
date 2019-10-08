package Stack;

import java.util.Stack;

public class validParenthesis {

    /***
     * time: O(n)
     * space: O(n)
     * @param input
     * @return
     */
    public static boolean valid(String input){
        /***
         * base case: if length = 1 then false since
         */
        if(input.length() == 0) return true;
        if(input.length() == 1) return false;
        // stack named open to store all open paren
        Stack<Character> open = new Stack<>();

        int i = 0;
        while( i < input.length()){
            char paren = input.charAt(i);
            // add to the open stack if the paren is the open paren
            if(paren == '[' || paren == '{' || paren == '(') open.add(paren);
            // if the open stack is empty
            if(open.isEmpty()){
                // if the paren is end paren then "}()" is false since missing the open paren
                if(paren == '}' || paren == ']' || paren == ')') return false;
                // if the open stack is not empty
            }else{
                // if the open and end paren not match then false
                if(paren == ']' && open.pop() != '[') return false;
                else if (paren == '}' && open.pop() != '{') return false;
                else if( paren == ')' && open.pop() != '(') return false;
            }
            i++;
        }
// if at the emd the open stack is not empty then false
        if(open.size()> 0) return false;

        // if go through all the test case then true
        return true;
    }

    public static boolean validPalindrome(String s) {

        if(s.length() == 0 || s.length() == 1) return true;
        s = s.toLowerCase();

        int lo = 0, hi = s.length() - 1;
        int count = 0;

        // System.out.println("valid = "+ isPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        while(lo <= hi){
            if(count >= 1){
                if( s.charAt(lo) != s.charAt(hi)) return false;
            } else{
                if( s.charAt(lo) != s.charAt(hi)){
                    System.out.println("s.charAt(lo) = "+ s.charAt(lo));
                    System.out.println("s.charAt(hi) = "+ s.charAt(hi));
                    System.out.println("substring = " + s.substring(lo,hi - 1));

                    if(s.charAt(lo+1) == s.charAt(hi)) lo++;
                    else if(s.charAt(hi - 1) == s.charAt(lo)) hi--;
                    else lo++;
                    count++;
                    continue;
                }
            }
            lo++;
            hi--;
        }

        return true;


    }

    public static void main(String[] args){
        String input = "{[]}";
        System.out.println(valid(input));
//        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
//        System.out.println("abcd".substring(1,3));

    }
}
