package GoogleInterviewPractice;

import java.util.PriorityQueue;

public class minNumberOfChairs {

    public static int[][] temp;

    public static void sort(int[][] a){
        temp = new int[a.length][2];
        mergeSort(a,0,a.length - 1);
    }

    public static void mergeSort(int[][] a,int lo,int hi){
        if(lo >= hi) return;
        int middle = (hi - lo)/2 + lo;
        mergeSort(a,lo,middle);
        mergeSort(a,middle+1,hi);
        merge(a,lo,middle,hi);
    }

    public static void merge(int[][] a, int lo, int mid, int hi){
        for(int i = lo; i <= hi; i++) temp[i] = a[i];
        int startLo = lo,startHi = mid + 1;
        for(int i = lo; i <= hi; i++){
            if(startLo > mid) a[i] = temp[startHi++];
            else if(startHi > hi) a[i] = temp[startLo++];
            else if(temp[startLo][0] > temp[startHi][0]  ) a[i] = temp[startHi++];
            else a[i] = temp[startLo++];
        }
    }

    public static int minNumberOfChair(int[] start, int[] end) {
        int[][] time = new int[start.length][2];
        for (int i = 0; i < start.length; i++) {
            int[] intervals = new int[2];
            intervals[0] = start[i];
            intervals[1] = end[i];
            time[i] = intervals;
        }

        // sort accordingly to the start time
        sort(time);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // add the first intervals start earliest
        minHeap.add(time[0]);
        // loop from the next meeting
        for (int i = 1; i < time.length; i++) {
            int[] earliestEnd = minHeap.remove();
            int[] currentInterval = time[i];
            // if the earliest end time done before or right the same time of start time of current interval
            if (earliestEnd[1] <= currentInterval[0]) {
                // we can record the end time of the current interval and use the same room
                earliestEnd[1] = currentInterval[1];
                // else if the start time of the currentInterval is bigger then the earliestEnd then add to minHeap for another room
            } else minHeap.add(currentInterval);
            // add the earliestEnd back to the minHeap for the future check
            minHeap.add(earliestEnd);
        }

        return minHeap.size();

    }

    public static void main(String[] args){

        int[] start = {1, 2, 6, 5, 3};
        int[] end = {5, 5, 7, 6, 8};

        System.out.println("The minimum of chair needed is "+ minNumberOfChair(start,end));

    }
}
