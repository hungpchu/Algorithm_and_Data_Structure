package Sorting;

public class KendallTauDistance extends Inversion{

    /***
     * Kendall tau distance = numbers of pairs that are in different order rather than relative
     * order in the 2 rankings
     */
    public static int distanceBetween(int[] arr1, int[] arr2){
        /***
         * index of arr1 become value at index and
         * value at index become index
         */
        int[] arr1Inverse = inversionArray(arr1);
        int[] mapInverse = new int[arr1.length];
        /***
         * mapInverse will be the combination of arr1 and arr2 when value of arr2 become index of map
         * Inverse and value at mapInverse will be the index through inversion of both arr1 and arr2
         */
        for(int i = 0; i < arr2.length; i++) mapInverse[i] = arr1Inverse[arr2[i]];
        return inversionCount(mapInverse);
    }

    public static void main(String[] args){
        int[] arr1 = {0,3,1,6,2,5,4};
        int[] arr2 = {1,0,3,6,4,2,5};
        System.out.println("Kendall Tau distance = "+ distanceBetween(arr1,arr2));
    }
}
