package Sorting;

/***
 * time: 0(logn)
 * space: O(n)
 * merge sort is sorting algorithm used in Arrays.sort()
 */
public class MergeSort extends shellSort {



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
