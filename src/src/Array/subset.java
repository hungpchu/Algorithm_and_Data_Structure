package Array;

import java.util.ArrayList;

public class subset {
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        return iterativeSolution(nums);
    }

    /***
     * function require 4 main factors: level, prevSet, newSet and result
     * @param nums
     * @return
     */

    public static ArrayList<ArrayList<Integer>> iterativeSolution(int[] nums){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // add the empty set into the res
        res.add(new ArrayList<>());
        System.out.println("[]");
        for(int n : nums){
            // create newest level each time of checking next number for avoiding adding duplicate set
            ArrayList<ArrayList<Integer>> level = new ArrayList<>();
            // loop through all the previous set in the result
            for(ArrayList<Integer> prevSet : res){
                // create newSet base on the previous set
                ArrayList<Integer> newset = new ArrayList<>(prevSet);
                // add new number into the newSet
                newset.add(n);
                System.out.print("[");
                for(int num: newset ) System.out.print(num + ",");
                System.out.println("]");
                // add newSet into the newLevel
                level.add(newset);
            }
            // add all the newSet from the level to the res
            res.addAll(level);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        ArrayList<ArrayList<Integer>> subset = subsets(nums);
//        for(ArrayList<Integer> sub: subset){
//            for(int num: sub) System.out.print( num + " ");
//            System.out.println();
//        }
    }
}
