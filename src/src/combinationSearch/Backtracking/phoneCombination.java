package combinationSearch.Backtracking;

import java.util.HashMap;

public class phoneCombination {

    public static HashMap<Character, String> hm;

    public static void phoneCombination(String input, String prefix, int indexHm){
        // base case: if the indexHm > input length then return
        if(indexHm > input.length()) return;
        // base case if prefix get to the length of input then
        // return
        if(prefix.length() == input.length()){
            System.out.println(prefix);
            return;
        }
        String phone = hm.get(input.charAt(indexHm));
        // loop through each string relate to phone digit
        for(int index = 0; index < phone.length();index++){
            // store the current prefix for next loop
            String temp = prefix;
            // add to the current combination
            prefix += phone.charAt(index);
            // check the next string from the next digit
            phoneCombination(input,prefix,indexHm+1);
            // clean up
            prefix = temp;
        }
    }
    public static void main(String[] args){
        hm = new HashMap<>();
        hm.put('2',"abc");
       hm.put('3',"def");
       hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
       phoneCombination("289","",0);
    }
}
