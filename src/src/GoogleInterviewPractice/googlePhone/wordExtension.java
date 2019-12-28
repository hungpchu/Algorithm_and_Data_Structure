package GoogleInterviewPractice.googlePhone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wordExtension {
    public  static List<int[]> pair;
    public static HashMap<Character,Character> hm;


    public static List<int[]> wordExtension(String input){
        List<int[]> res = new ArrayList<>();
        int i = 0, end = 0;
        while(i < input.length() - 1){
            int start = i;
            while(i + 1 < input.length() && input.charAt(i) == input.charAt(i+ 1)){
                i++;
                end = i;
            }
            if(end - start > 1){
                int[] pair = new int[2];
                pair[0]=start;
                pair[1] = end;
                res.add(pair);
            }
            if(end != 0){
                i = end;
                end = 0;
            }else i++;
        }
        return res;
    }

    public static void allW(int start, int size, String s, String prefix){
        if(size == pair.size()) return;
        if(start == s.length()){
            System.out.println(prefix);
            return;
        }
        if(prefix.length() > 0 && prefix.charAt(prefix.length() - 1) == s.charAt(s.length() - 1)) System.out.println(prefix);

        String tem1 = prefix;

            int st = pair.get(size)[0];
            int en = pair.get(size)[1];
            while(st <= start && start <= en){
                prefix += s.charAt(start);
                if(en < s.length()) allW(en + 1, size,s,prefix);
                else allW(en,size,s, prefix);
                start++;

            }
            if(start > en) size++;

            prefix = tem1;
            if (start < s.length()) prefix += s.charAt(start);
            allW(start + 1, size, s, prefix);

    }

    public static void main(String[] args){
        String input = "hhhiiii";
        pair = wordExtension(input);

//        for(int[] p: wordExtension(input)) System.out.println(p[0] + " " + p[1]);
        allW(0,0,input,"");

    }
}
