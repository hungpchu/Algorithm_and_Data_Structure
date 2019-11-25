package combinationSearch.Subsets;

/***
 * Problem: start with empty stage, 4 character enter and exit
 * one at a time such that each subset of actors appears exactly 1
 */
public class beckettPlay {

    // looks like the ruler function
    // traverse inorder -> like left then root then right
    public static void moves(int number, boolean enter){
        if(number == 0) return;
        // traverse post order -> enter
        moves(number - 1,true);
        if(enter) System.out.println("enter " + number);
        else System.out.println("exit " + number);
        // then exit
        moves(number-1,false);
    }

    public static void main(String[] args){
        // 1st guy will enter
        moves(4,true);
    }
}
