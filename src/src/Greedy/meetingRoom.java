package Greedy;

import java.util.PriorityQueue;

/***
 * Greedy algorithm
 */
public class meetingRoom {

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
            else if (temp[startL][0] > temp[startR][0]) arr[i] = temp[startR++];
            else arr[i] = temp[startL++];
        }
    }

    /***
     * Find the min room to schedule all meeting interval
     * Time: O(NlogN) since using merge sort
     * @param time
     * @return max compatible job
     */
    public static int minRoom(int[][] time){
        if(time.length == 0 ) return 0;
        // sort increasing order of earliest start time first
        sort(time);
        // set the lambda to the increasing order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // add the min start interval
        pq.add(time[0]);
        // traverse through all other interval
        for(int i = 1; i < time.length; i++){
            int[] earliestInterval = pq.remove();
            int earliestEnd = earliestInterval[1];
            int currentStart = time[i][0];
            // if there is a compatible
            // set the earliest end of current earliest interval to current interval start
            if(earliestEnd <= currentStart) earliestInterval[1] = currentStart;
            // if not then add the current interval for another room
            else pq.add(time[i]);
            // readd the current earliest interval back to the pq
            pq.add(earliestInterval);
        }
        // the minimum room required will be the size of pq
        return pq.size();
    }

    public static void main(String[] args){
        int[][] interval = {{900,1030},{900,1030},{900,1030},{1100,1230},{1100,1400},{1300,1400},{1300,1430},{1400,1630},{1500,1630},{1500,1630}};
        System.out.println("The min room required is "+ minRoom(interval));
    }
}
