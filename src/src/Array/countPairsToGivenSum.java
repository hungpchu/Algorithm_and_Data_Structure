package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class countPairsToGivenSum {

    public static int countPairs(List<Integer> arr, long k) {
        // Write your code here
        if(arr.size() < 0 || arr.size() > 5*Math.pow(10,5)) return 0;
        if(k < 0 || k > 5*Math.pow(10,9)) return 0;
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,Boolean> hm = new HashMap<>();
        int count = 0;

        for(int n: arr){

            if(hs.contains(n) && hm.get(n) == false){
                count++;
                hm.put(n,true);
                hm.put((int) k - n, true);
                hs.remove(n);
                hs.remove((int)k - n);
            }else{
                if(!hm.containsKey((int) k - n)){
                    hs.add((int)k - n);
                    hm.put((int)k - n, false);
                }
            }
        }
        return count;
    }

    public static void main(String[] args){

    }
}
