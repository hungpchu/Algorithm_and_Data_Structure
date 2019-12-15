package String;

import java.util.ArrayList;
import java.util.List;

// time: O(n*m) with n is the length of not condense string and m is the length of condense string
// space:O(m) with m is the length of condense string
public class countStep {

    public static int countStep(String s){
        if(s.length() == 0) return 0;
        int count = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        String res = "";
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) != '_'){
                list.add(i);
                res += s.charAt(i);
            }
        }


        int i = 0, j = 0;
        while(i < s.length()){
            if(j > res.length() - 1) return count;
            if(s.charAt(i) == res.charAt(j)){
                int start = i - j, index = 0, curr = 0;
                for(int in = start; in < start + res.length() ;in++){
                    curr+= Math.abs(list.get(index) - in);
                    index++;
                }
                count = Math.min(count,curr);
                j++;
            }
            i++;
        }


        return count;
    }

    public static void main(String[] args){
        String s = "a_bc_d_e";
        System.out.println("count = "+ countStep(s));
    }
}
