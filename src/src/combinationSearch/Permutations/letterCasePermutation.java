package combinationSearch.Permutations;

public class letterCasePermutation {

    public static void letterPermutation(String input, String prefix, int start){
        if(start > input.length()) return;
        if(prefix.length() == input.length()) {
            System.out.println(prefix);
            return;
        }
        if(Character.isLetter(input.charAt(start))) {
            letterPermutation(input, prefix + Character.toLowerCase(input.charAt(start)), start + 1);
            letterPermutation(input, prefix + Character.toUpperCase(input.charAt(start)), start + 1);
        }else{
            letterPermutation(input,prefix+input.charAt(start),start+1);
        }
    }

    public static void main(String[] args){
        letterPermutation("a1b2c3","",0);
    }
}
