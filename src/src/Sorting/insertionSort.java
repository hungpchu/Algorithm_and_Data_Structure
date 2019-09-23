package Sorting;

public class insertionSort extends selectionSort{

    /***
     * time: O(n^2)
     * space: O(1)
     * main idea: compare the current index from the right with all left elements and insert at the proper position.
     * faster then selection sort, which finds min then compare. Insertion swap in place when there is min
     */
    public static void insertionSort(int[] a){

        for(int i = 0; i < a.length; i++){
            for(int j = i; j > 0 && a[j] < a[j - 1]; j--){
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] a ={4,5,4,7,1,3};
        insertionSort(a);
        show(a);

    }
}
