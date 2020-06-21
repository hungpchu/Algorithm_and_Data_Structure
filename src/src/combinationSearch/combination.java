package combinationSearch;


import java.util.HashSet;

public class combination {

    public static int[] arr = {1,4,2,2,3};;
    public static int tempIndex;
    public static HashSet<Integer> hs;

    public static void combinationString(String input, String prefix, int start, int size){
        if(start > size) return;
        if(prefix.length() == size){
            System.out.println(prefix);
            return;
        }
        System.out.println("here");
        for(int i = start; i < input.length();i++){
            if(prefix.length() > 0) {
                // so that we choose right combination to the next index
                if (tempIndex >= i) continue;
            }
            String temp = prefix;
            prefix += input.charAt(i);
            tempIndex = i;
            combinationString(input,prefix,start+1,size);
            prefix = temp;
            tempIndex = 0;
        }

    }

    public static void combinationArray(int[] arr, int start, int size){
        if(start > size) return;
        if(start == size){
            for(int i = 0; i < size; i++) System.out.print(arr[i]);
            System.out.println();
            return;
        }
        for(int i = start; i < arr.length; i++){
            if(start > 0 && i <= tempIndex) continue;
            tempIndex = i;
            int temp = arr[start];
            arr[start] = arr[i];
            combinationArray(arr,start+1,size);
            arr[start] = temp;
            tempIndex = 0;

        }
    }

    public static void permutationString(String input, String prefix, int size ){

        if(prefix.length() == size){
            System.out.println(prefix);
            return;
        }

        for(int i = 0; i < input.length();i++){

            String temp = prefix;
            prefix += input.charAt(i);
            permutationString(input,prefix,size);
            prefix = temp;
        }
    }

    public static void exchange(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void permutationArray(int[] arr, int start, int size){
        if(start == size){
            for(int n: arr)System.out.print(n);
            System.out.println();
            return;
        }
        for(int i = start; i < arr.length;i++){
            // swap index so that we do not have duplicate permutation
            exchange(arr,i,start);
            permutationArray(arr, start + 1, size);
            // clean up for the new permutation
            exchange(arr,i,start);
        }
    }


    public static void main(String[] args){
        int r = 2;
        String input = "123";
        tempIndex = 0;
        hs = new HashSet<>();
        int[] arr = {1,2,3,4};
//        permutationArray(arr,0,4);
        combinationArray(arr,0,r);
//        combinationString(input,"",0,r);
//        permutationString(input,"",r);
    }
}
