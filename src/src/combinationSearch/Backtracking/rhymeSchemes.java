package combinationSearch.Backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class rhymeSchemes {

    public static int countNum;
    public static char[] alphabet = {'a','b','c','d','e'};
    public static char[] used;
    public static HashSet<String> hs;
    public static int count(int N){
        countNum = 0;
        used = new char[N+1];
        hs = new HashSet<>();
        for(int i = 0; i < used.length; i++) used[i] = alphabet[i];
        dfs("",N,0);
        return countNum;
    }

    public static void dfs(String prefix,int N,int count){

       if(prefix.length() == N){
           //count++;
           if(!validIsomo(prefix)){
               hs.add(prefix);
               countNum++;
           }
           else if (validIsomo(prefix)){
               System.out.println("exit = "+ countNum);
              return;
           }
           System.out.println("prefix = " + prefix);
       }
//        System.out.println("prefix = " + prefix);
        for(int i = 0; i < N; i++){
            String temp = prefix;
            int tempCount = count;
            prefix += used[i];
            if(prefix.length() > N ){

                continue;
            }
        dfs(prefix,N,count+1);

            prefix = temp;
          count = tempCount;


        }
    }

    public static boolean validIsomo(String string){
        for(String s: hs){
            if(isIsomorphic(s,string)) return true;
        }
        return false;
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(!hm.containsKey(sChar)){
                hm.put(sChar,tChar);
                // check for tChar has already been mapped
                if(!hs.contains(tChar)) hs.add(tChar);
                else return false;
            }
            else{
                if(hm.get(sChar) != tChar) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int N = 4;
        System.out.println("count = " + count(N));
    }


}
