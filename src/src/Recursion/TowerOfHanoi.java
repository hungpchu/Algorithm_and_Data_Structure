package Recursion;

/***
 * Rule:
 *  1/ Never put large disc on smaller disc
 *  2/ Move disc 1 at a time
 *  -> kinda like the ruler
 *
 *  Move right = 1 to 2, 2 to 3 or 3 to 1
 *  Move left = 3 to 2, 2 to 1 or 1 to 3
 *
 *  Move n - 1 disc to the left
 *  Move n to right
 *  Move n - 1 to the left
 *
 *  Time: O(logN) since the 2 side are the same instead of 2^n - 1 where N is the number of disc
 */

public class TowerOfHanoi {
    public static int count;
    public static String moveTower(int place, boolean left){
        if(place == 0) return " ";
        String move;
        count++;
        if(left) move = Integer.toString(place) + "L";
        else move = Integer.toString(place) + "R";
        String moveSmallerN = moveTower(place-1,!left);
        return moveSmallerN + move + moveSmallerN;
    }

    public static void main(String[] args){
        count = 0;
        System.out.println("Step to move the tower of size 64 = " + moveTower(20,true));
        System.out.println("count = "+ count);
    }
}
