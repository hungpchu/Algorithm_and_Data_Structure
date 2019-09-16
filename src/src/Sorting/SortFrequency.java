package Sorting;

import java.util.HashMap;

public class SortFrequency {

    public static  HashMap<Integer,SortFrequency> hm;


        int count;
        int index;
        public SortFrequency(int count, int index){
            this.count = count;
            this.index = index;
        }

        public void setCount(int count){ this.count = count;}

        public int getCount() { return this.count;}




    public static int partition(int[] arr, int lo, int hi){
        int pivot = arr[hi];
        int i = lo - 1;

        for(int j = lo; j < hi  ; j++ ){
            // check count
            if(hm.get(arr[j]).count > hm.get(pivot).count){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            else if(hm.get(arr[j]).count == hm.get(pivot).count){
                if(hm.get(arr[j]).index < hm.get(pivot).index){
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[hi ];
        arr[hi] = temp;


        return i;
    }

    public static void quickSort(int[] a, int lo, int hi){
        if(lo < hi){
            int pivot = partition(a,lo,hi);
            quickSort(a,lo,pivot - 1);
            quickSort(a,pivot + 1, hi);
        }
    }

    public static void main(String[] args){
        int[] a = {3,3,1,1,1,8,3,6,8,7,8};
//        quickSort(a,0,a.length - 1);
//        for(int n: a) System.out.print(n + " ");
        hm =  new HashMap<>();
        for( int i = 0; i < a.length; i++){
            if(hm.containsKey(a[i])){
                SortFrequency t = hm.get(a[i]);
                t.count++;
            }

            if(!hm.containsKey(a[i]))     hm.put(a[i], new SortFrequency(1,i));


        }
        System.out.println();
        quickSort(a,0,a.length - 1);
        for(int n: a) System.out.print(n + " ");
    }

}
