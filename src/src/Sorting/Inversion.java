package Sorting;

public class Inversion {


    /***
     * inverse array will reverse the index and value where index becomes
     * value at index and value at index become the index
     */
    public static int[] inversionArray(int[] arr){
        /***
         * normal array with index as index and
         * value at index as value at index
         */
        int[] inversion = new int[arr.length];
        /***
         * through the loop, value at index become index and
         * index became the value at index
         */
        for(int i = 0; i < arr.length; i++) inversion[arr[i]] = i;
        return inversion;
    }

    /***
     * Inversion count indicate how many step needed for the array to be
     * fully sorted
     */
    public static int inversionCount(int[] arr){
        int count = 0;
        return inversionLevel(arr,0,arr.length - 1,count);
    }

    public static int inversionLevel(int[] arr, int lo, int hi, int count){
        if(lo >= hi) return count;
        int middle = (hi - lo)/2 + lo;
        count = inversionLevel(arr,lo,middle,count);
        count = inversionLevel(arr,middle+1,hi,count);
        count = checkInversion(arr,lo,middle,hi,count);
        return count;
    }

    public static int checkInversion(int[] arr, int lo, int middle, int hi, int count){
        int startLeft = lo, startRight = middle + 1;
        for(int i = lo; i <= hi; i++){
            if(startLeft > middle) startRight++;
            else if(startRight > hi) startLeft++;
            else if (arr[startLeft] > arr[startRight]){
                startRight++;
                count++;
            }
            else startLeft++;
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr = {1,2,6,4,-2,3,5,0,7};
        System.out.println("Number of inversion = " + inversionCount(arr));
    }
}
