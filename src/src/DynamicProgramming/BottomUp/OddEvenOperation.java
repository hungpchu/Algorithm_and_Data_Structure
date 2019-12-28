package DynamicProgramming.BottomUp;

import java.util.HashMap;

public class OddEvenOperation {
    public static int max;
    public static HashMap<String,Integer> hm;
    public static int maxScore(int[] a){
        max = 0;
        hm = new HashMap<>();
        traverse(a,0,0,a.length - 1,1);
        return max;
    }

    public static void traverse(int[] a,int score, int start, int end, int operation){
        if(start > end){
            max = Math.max(max,score);
            return;
        }
        int sum = 0;
        String key  = String.valueOf(start) + String.valueOf(end);
        if(hm.containsKey(key)) sum = hm.get(key);
        else{
            for(int i = start; i <= end; i++) sum += a[i];
            hm.put(key,sum);
        }
        if(operation % 2 != 0 ) score = score + sum;
        else score = score - sum;

        traverse(a,score,start+1,end,operation+1);
        traverse(a,score,start,end-1,operation+1);
    }

    public static void main(String[] args){
        int[] a = {6,5,4};
        System.out.print("The max score is = " + maxScore(a));
    }
}
