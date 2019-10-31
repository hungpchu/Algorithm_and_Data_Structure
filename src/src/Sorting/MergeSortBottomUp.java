package Sorting;

public class MergeSortBottomUp extends MergeSort {

    public static int[] temp;

    public static void sort(int []arr){
        int length = arr.length;
        temp= new int[length];
        for(int subArray = 1; subArray < length; subArray = subArray + subArray){
            for(int lo = 0; lo < length - subArray; lo += subArray + subArray){
                merge(arr,temp,lo,lo+subArray-1,Math.min(lo+subArray+subArray - 1, length - 1));
            }
        }
    }

    public static void main(String[] args){
        int[] a = {5,4,27,1,2,0,98};
        sort(a);
        System.out.print("Num in a: ");
        for(int num: a) System.out.print(num + ",");
    }
}
