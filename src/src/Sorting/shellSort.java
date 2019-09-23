package Sorting;

public class shellSort extends insertionSort {

    /***
     * better implement of insert sort -> swap the smallest element from the end of array to the higher place to swap in future
     * @param a
     */
    public static void shellSort(int[] a)
    { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1)
        { // h-sort the array. An h-sorted sequence is h interleaved sorted subsequences
            for (int i = h; i < N; i++)
            { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && a[j] < a[j-h]; j -= h) {
                    int temp = a[j];
                    a[j ] = a[j - h];
                    a[j-h] = temp;
                }

            }
            h = h/3;
        }
    }

    public static void main(String[] args){
        int[] a = {4,3,5,6,1,0,-1,-4};

        shellSort(a);
        show(a);

    }
}
