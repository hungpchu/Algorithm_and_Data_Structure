package Greedy;

import java.util.PriorityQueue;

public class maxMutualJob {

    public static int[][] temp;

    public static void sort(int[][] arr){
        temp = new int[arr.length][2];
        mergeSort(arr,0,arr.length - 1);
    }

    public static void mergeSort(int[][] arr,int lo, int hi){
        if(lo >= hi) return;
        int middle = (hi - lo)/2 + lo;
        mergeSort(arr,lo,middle);
        mergeSort(arr,middle+1,hi);
        merge(arr,lo,middle,hi);
    }

    public static void merge(int[][] arr, int lo, int middle, int hi){
        for(int i = lo; i <= hi; i++) temp[i] = arr[i];
        int startL = lo, startR = middle + 1;
        for(int i = lo; i <= hi; i++){
            if(startL > middle) arr[i] = temp[startR++];
            else if(startR > hi) arr[i] = temp[startL++];
            // check for the earliest finish time
            else if (temp[startL][1] > temp[startR][1]) arr[i] = temp[startR++];
            else arr[i] = temp[startL++];
        }
    }

    /***
     * Time: O(NlogN) since using merge sort
     * @param time
     * @return max compatible job
     */
    public static int maxMutualjob(int[][] time){
        if(time.length == 0) return 0;
        // sort time with the earliest finish time first order
        sort(time);
        int countJob = 1;
        int[] earlistFinish = time[0];
        for(int i = 1; i < time.length;i++){
            int currentStart = time[i][0];
            // check to merge 2 job together
            if(earlistFinish[1] <= currentStart){
                earlistFinish[1] = time[i][1];
                ++countJob;
            }
        }
        return countJob;
    }

    public static void main(String[] args){
        int[][] time = {{0,6},{1,4},{3,5},{3,8},{4,7},{5,9},{6,10},{8,11}};
        System.out.println("Max job that are compatible is " + maxMutualjob(time));
    }
}
