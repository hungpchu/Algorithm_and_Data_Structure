package String;

public class LSDstringSort {

    /***
     * Time: O(N + R) with R is range and N is the length of the array
     * Good if the array all have the same number of element or the range is small
     */
    public static void countingSort(int[] arr){
        int arrLength = arr.length;
        // range represent the number from 0 to arr.length
        int range = arrLength;
        // store the sorted number
        int[] temp = new int[arrLength];
        // count represent to range of number
        int[] count = new int[range];
        /***
         * With number in range as index, value at index will be
         * frequency of number(index) in array
         */
        for(int i = 0 ; i < count.length; i++) ++count[arr[i]];
        /***
         * Transform the value at index to position at the temp array
         * The number will be cumulative base on 1st non-0 value in
         * count array
         * The value at index - 1 indicated the end index of the number as index
         */
        for(int i = 1; i < count.length; i++) count[i] += count[i-1];

        for(int i = 0; i < temp.length;i++){
            // obtain the number from the original array
            int arrNum = arr[i];
            // take its new index from the count array with minus 1
            int index = count[arrNum] - 1 ;
            // hence with the new index, value from original array will be in sorted
            // position
            temp[index ] = arr[i];
            // decrease the new position for the future duplicate number
            // from the original array
            count[arrNum]--;
        }
        // copy all the value from temp to arr
        for(int i = 0; i < arrLength; i++) arr[i] = temp[i];

    }

    public static void main(String[] args){
        int[] arr = {1,2,3,3,0,0,3,3,3,3};
        countingSort(arr);
        for(int n: arr) System.out.print(n +",");
    }
}
