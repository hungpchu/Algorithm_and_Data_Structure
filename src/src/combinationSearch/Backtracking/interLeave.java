package combinationSearch.Backtracking;

public class interLeave {

    public static  void interLeave(String s1, String s2, String prefix, int startL, int startR){
        if(prefix.length() == s1.length() + s2.length()){
            System.out.println(prefix);
            return;
        }

        if(startL < s1.length() ) interLeave(s1,s2,prefix + s1.charAt(startL),startL+1,startR);
        if(startR < s2.length() ) interLeave(s1,s2,prefix + s2.charAt(startR),startL,startR+1);

    }

    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "c";
        interLeave(s1,s2,"",0,0);
    }
}
