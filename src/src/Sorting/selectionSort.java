package Sorting;

public class selectionSort {

    /***
     * time: O(n^2)
     * space: O(1)
     * main idea: find the min element in the array then swap
     */
    public static void selectionSort(int[] a){

        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if(a[min] > a[j]) min = j;
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
         }
    }

    public static void show(int[] a){
        for(int n: a) System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args){
        int[] a = {4,3,5,3,1};
        selectionSort(a);
        show(a);
    }

}
