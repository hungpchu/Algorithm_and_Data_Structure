package DynamicProgramming.BottomUp;

import java.util.HashMap;
import java.util.List;

public class OddEvenOperation {
    public static int max;
    public static HashMap<String,Integer> hm;
    public static int maxScore(int[] a){
        max = 0;
        hm = new HashMap<>();
        int sum = 0;
        for(int num: a) sum += num;
        traverse(a,0,0,a.length - 1,sum,1);
        return max;
    }

    public static void traverse(int[] a,int score, int start, int end,int sum, int operation){
        if(start > end){
//            System.out.println("oper = " + operation);
            max = Math.max(max,score);
            return;
        }

        if(operation % 2 != 0 ){
            score +=  sum;
            if(score - (sum- a[start]) > score - (sum - a[end])){
                traverse(a,score,start+1,end,sum- a[start],operation+1);
            }else traverse(a,score,start,end-1,sum - a[end],operation+1);
        }
        else {
            score = score - sum;
            if(score + (sum -  a[start]) > score + (sum - a[end])){
                traverse(a,score,start+1,end,sum- a[start],operation+1);
            }else traverse(a,score,start,end-1,sum - a[end],operation+1);
        }


//        traverse(a,score,start+1,end,sum- a[start],operation+1);
//        traverse(a,score,start,end-1,sum - a[end],operation+1);
    }

//    public static long getMaximumScore(int[] a){
//        int lo = 0, hi = a.length - 1;
//        int loop = 0, operation = 1,score = 0,sum = 0;
//        for(int i = lo; i <= hi;i++) sum += a[i];
//        while(operation != a.length ){
//            if(operation % 2 != 0){
//                score += sum;
//                int max = Math.max(a[lo],a[hi]);
//                sum -= max;
//                if(max == a[lo]) lo++;
//                else hi--;
//            }else{
//                score -= sum;
//                int max = Math.max(a[lo],a[hi]);
//                sum -= max;
//                if(max == a[lo]) lo++;
//                else hi--;
//            }
//            loop++;
//            operation++;
//        }
//        System.out.println(" oper = " + operation + " lo = " + lo + " hi = " + hi);
//        return score;
//    }

    public static void main(String[] args){
        int[] a = {432,4,3,5};
//        int[] a = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println("The max score is = " + maxScore(a) + " size = " + a.length);
//        System.out.println("The max score is = " + getMaximumScore(a));
    }
}
