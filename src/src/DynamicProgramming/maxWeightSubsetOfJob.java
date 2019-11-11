package DynamicProgramming;

import java.util.HashMap;

/***
 * Weight interval scheduling problem
 * find max weight subset of mutually compatible job
 */
public class maxWeightSubsetOfJob {

    public static int count;
    public static Integer[] cache;

    /***
     * Assume we sort before hand by the earliest finished time first
     * Time: O(logN)
     * @return
     */
    public static int maxSubset(){
        // pair the compatible job together with the index value is job and value
        // at index is its compatible job
        int[] compatibleJob = new int[9];
        cache = new Integer[9];
        compatibleJob[0] = 0;
        compatibleJob[1] = 0;
        compatibleJob[2] = 0;
        compatibleJob[3] = 0;
        compatibleJob[4] = 1;
        compatibleJob[5] = 0;
        compatibleJob[6] = 2;
        compatibleJob[7] = 3;
        compatibleJob[8] = 5;

        // assign job value for each job
        HashMap<Integer,Integer> jobWeight = new HashMap<>();
        jobWeight.put(0,0);
        jobWeight.put(1,4);
        jobWeight.put(2,30);
        jobWeight.put(3,20);
        jobWeight.put(4,8);
        jobWeight.put(5,2);
        jobWeight.put(6,13);
        jobWeight.put(7,4);
        jobWeight.put(8,10);
        return maxWeightDynamic(8,compatibleJob,jobWeight);
    }

    /***
     * top down dynamic
     */
    public static int maxWeight(int jobID, int[] compaJob,HashMap<Integer,Integer> hm){
        if(jobID == 0) return 0;
        // get the job weight through hashmap and plus with its compatible job
        // then compare with j-1 job
        count++;
        int currentCompatible = hm.get(jobID) + maxWeight(compaJob[jobID],compaJob,hm);
        int potentialCompatible = maxWeight(jobID - 1,compaJob,hm);
        return Math.max(currentCompatible,potentialCompatible);
    }

    /***
     * bottom up dynamic oh shit-> so nice
     */
    public static int maxWeightDynamic(int jobID, int[] compaJob,HashMap<Integer,Integer> hm){
        cache[0] = 0;
        for(int i = 1; i <= jobID; i++)  cache[i] = Math.max(hm.get(i) + hm.get(compaJob[i]),cache[i-1]);

        return cache[jobID];
    }

    public static void main(String[] args){
        count = 0;
        System.out.println("Max value of subset of compatible job is " + maxSubset());
        System.out.println("Run time is "+ count);
    }
}
