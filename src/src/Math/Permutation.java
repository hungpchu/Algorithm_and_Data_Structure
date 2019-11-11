package Math;

public class Permutation {
    int[] arr;
    int permutationNumber;
    public Permutation(int N, int sizeChoosen){
        arr = new int[N + 1];
        arr[0] = 1;
        // init the array
        for(int i = 1; i < N + 1; i++) arr[i] = arr[i - 1] + 1;
        // start with the first index as 0
        permutationSequence(0,sizeChoosen);
    }

    public void print(int size){
        for(int i = 0; i < size; i++ )System.out.print(arr[i] +" ");
        System.out.println();
    }

    public void exchangeIndex(int startIndex,int currentIndex){
        int temp = arr[startIndex];
        arr[startIndex] = arr[currentIndex];
        arr[currentIndex] = temp;
    }

    /***
     * Permutation formula:
     *  permutation = n! = n*(n-1)!
     *  For instance:
     *  Permutation of 4 is 3*2*1 = 6
     */
    public  void permutationSequence(int startIndex,int sizeChoosen){
        if(startIndex == sizeChoosen) {
            print(sizeChoosen);
            permutationNumber++;
        }
        for(int currentIndex = startIndex; currentIndex < arr.length; currentIndex++){
            // exchange the current position with first
            exchangeIndex(currentIndex,startIndex);
            // enumerate through (N - 1)! number left
            permutationSequence(startIndex + 1,sizeChoosen);
            // clean up to put the position back
            exchangeIndex(currentIndex,startIndex);
        }
    }

    public static void main(String[] args){
        Permutation permutation = new Permutation(3,3);
        System.out.println("The number of permutation is " + permutation.permutationNumber);
    }
}
