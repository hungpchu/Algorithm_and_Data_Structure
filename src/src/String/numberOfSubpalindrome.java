package String;

import java.util.HashSet;

public class numberOfSubpalindrome {

    public static int numberOfSubpalindrome(String s) {
        // Write your code here
        // HashSet<Character> hs = new HashSet<>();
        HashSet<String> hs = new HashSet<>();

        //  use start and end for the longestPalindrome
        int start = 0;
        // maxLenght to keep track of the longest Palindrome
        int maxLengh = 0;
        int count = 0;
        hs.add(Character.toString(s.charAt(0)));
        for(int i = 1; i < s.length(); i++){
            //  use low and high to check the Palindrome from inside out
            int low = i - 1;
            int high = i;
            hs.add(Character.toString(s.charAt(i)));
            // check for the even longest one
            while( low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high) ){
                hs.add(s.substring(low,high + 1));
                high++;
                low--;
            }
            // check for the odd longest one
            high= i + 1;
            low = i - 1;
            while( low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high) ){
                hs.add(s.substring(low,high + 1));
                high++;
                low--;
            }
        }
        return  hs.size();

    }

    public static void main(String[] args){

    }

}
