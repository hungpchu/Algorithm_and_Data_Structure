package String;

import java.util.HashMap;

public class longest_substring_without_repeating_characters {

    public static int longestSubstring(String s){
        HashMap<Character,Integer> hm = new HashMap<>();

        int start = 0, end = 0, max = 0;

        while(end < s.length()){
            if(hm.containsKey(s.charAt(end))) start = Math.max(start,hm.get(s.charAt(end) ) + 1);
            hm.put(s.charAt(end), end);
            max = Math.max(max,end - start + 1);
            end++;
        }
//System.out.println("Start = " +start);
        return max;
    }

    public static void main(String[] args){
        String s = "dvgfvdfebcd";
        System.out.println("length = "+ longestSubstring(s));
    }
}
