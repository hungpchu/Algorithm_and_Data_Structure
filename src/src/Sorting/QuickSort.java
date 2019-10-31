package Sorting;

import java.util.Collections;
import java.util.Random;

public class QuickSort {

    // shuffle to protect quicksort from worst case
    public static int[] RandomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    public static void exchange(int[] a, int left,int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static int partition(int[] a,int lo, int hi){
        int left = lo + 1, right = hi, pivot = a[lo];
        while(true){
            while(a[left] < pivot){
                left++;
                if(left == hi ) break;
            }
                while(a[right] > pivot){
                    right--;
                    if(right == lo ) break;
                }
                if(left >= right) break;
                exchange(a,left,right);
        }
        // put the pivot in the final destination
        exchange(a,lo,right);
        return right;
    }

    public static void quickSort(int[] a, int lo, int hi){
        if(lo >= hi) return;
        int pivotIndex = partition(a,lo,hi);
        quickSort(a,lo,pivotIndex - 1);
        quickSort(a,pivotIndex + 1,hi);
    }

    public static void sort(int[] a){
        quickSort(a,0,a.length - 1);
    }

    /***
     * good for duplicate value
     * reduces time of sort from linearithmic to linear for array
     * with large number of duplicate key
     */
    public static void quickSort3Way(int[] a,int lo, int hi){
        if(lo >= hi) return;
        int left = lo, i = lo + 1, right = hi;
        int pivot = a[lo];
        while(i <= right){
            // exchange i and left
            if(a[i] < pivot){
                exchange(a,i,left);
                i++;
                left++;
                // exchange i and right
            }else if(a[i] > pivot){
                exchange(a,i,right);
                right--;
            }else i++;
        }
        quickSort3Way(a,lo,left - 1);
        quickSort3Way(a,right+1,hi);
    }

    public static void sort3way(int[] a){quickSort3Way(a,0,a.length - 1);}

    // utilize partition to find the kth number
    public static int findKthNumber(int[] arr, int kth){
        int lo = 0, hi = arr.length - 1;
        while(lo < hi){
            // pivot is the index to divide the array into smaller and bigger
            // part
            int pivot  = partition(arr,lo,hi);
            if(pivot == kth ) return arr[pivot];
            else if(pivot < kth) lo = pivot + 1;
            else hi = pivot - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a  = { 4,3,52,6,1,0};
//        sort3way(a);
        int kth  = 3;
        sort(a);
        System.out.println(kth + " th number is "+ findKthNumber(a,kth));
        for(int num: a) System.out.print(num+",");

    }
}
