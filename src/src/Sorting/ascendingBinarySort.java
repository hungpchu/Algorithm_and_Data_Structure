package Sorting;

import java.util.HashMap;

public class ascendingBinarySort {
    public static HashMap<Integer,Integer> hm;
    public static int[] temp;
    public static void sort(int[] a, int low, int hi){
        if(low >= hi) return;
        int middle = (hi - low)/2 + low;
        sort(a,low,middle);
        sort(a,middle + 1,hi);

        merge(a,low,middle,hi);
    }

    public static void merge(int[] a, int lo, int midd, int hi){
        for(int i = lo; i <= hi; i++) temp[i] = a[i];
        int startL = lo, startR = midd + 1;
        for(int i = lo; i <= hi; i++){
            if(startL > midd) a[i] = temp[startR++];
            else if(startR > hi) a[i] = temp[startL++];
            else if(hm.get(temp[startL]) < hm.get(temp[startR])) a[i] = temp[startL++];
            else if (hm.get(temp[startR]) < hm.get(temp[startL])) a[i] = temp[startR++];
            else{
                if(temp[startL] < temp[startR]) a[i] = temp[startL++];
                else a[i] = temp[startR++];
            }
        }
    }
    public static void main(String[] args){
        int[] a = {1,5,5,3,7,10,14};
         hm = new HashMap<>();
         temp = new int[a.length];
        for(int num: a){
            int key = num, count = 0;
            while(num > 0){
                ++count;
                num &= (num - 1);
            }
            hm.put(key,count);
        }
       sort(a,0,a.length - 1);
        for(int n: a) System.out.print(n+ " ");
    }

}
