package Sorting;

/***
 * time: 0(NlogN)
 * space: O(N) -> additional array for merging (temp)
 * merge sort is sorting algorithm used in Arrays.sort()
 * Merge sort run time explain:
 * Have n is the size of the array and logN is number of step that takes value
 * of n = 1.
 *  ->
 *
 */
public class MergeSort extends shellSort {


    /***
     * merge function will have the duty of merging all element in subarray in the time of N at most
     * when it goes up or pop from the stack of memory
     */
    public static void merge(int[] a, int[] temp, int lo, int mid, int hi){


        for(int k = lo; k <= hi; k++) temp[k] = a[k];
        int i = lo, j =  mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid) a[k] = temp[j++];
            else  if(j > hi) a[k] = temp[i++];
            else if(temp[j] < temp[i]) a[k] = temp[j++];
            else a[k] = temp[i++];
        }
    }

    /***
     * mergeSort will have the duty to divide the array in half until the we have N subArray of length 1
     * Thus mergeSort function will run in log_{2}N time which is the time for N to be 1
     * Since merge function stay inside the mergeSort -> merge will be executed along the way when mergeSort divide
     * the array in half -> thus the mergeSort will run in NlogN
     */
    public static void mergeSort(int[] a, int[] temp, int lo, int hi){
        if ( lo >= hi) return;
        int mid = (hi - lo)/ 2 + lo;
        mergeSort(a, temp, lo, mid);
        mergeSort(a, temp, mid + 1, hi);
        merge(a,temp,lo,mid,hi);
    }




    public static void sort(int[] a){
        int[] temp = new int[a.length];
        mergeSort(a,temp,0,a.length - 1);
    }



    public static void main(String[] args){

        int[] a = {5,3,0,4,2,1};
        sort(a);
        show(a);
    }
}
