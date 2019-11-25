package combinationSearch.Permutations;

/***
 * Similar problem:
 * How many ways are there to place N rooks on the N by N board so that no
 * rooks can attack any other?
 * -> Solution: N! placement or find the permutation
 */

public class Permutation {
    int[] arr;
    int permutationNumber;
    public Permutation(int N){
        arr = new int[N];
        // init the array
        for(int i = 0; i < arr.length; i++) arr[i] = i + 1;
        // start with the first index as 0
        permutationSequence(0);
    }

    public void print(){
        for(int i = 0; i < arr.length; i++ )System.out.print(arr[i] +" ");
        System.out.println();
    }

    // swap the currentIndex into the startPosition aka 0
    public void exchangeIndex(int startIndex,int currentIndex){
        int temp = arr[startIndex];
        arr[startIndex] = arr[currentIndex];
        arr[currentIndex] = temp;
    }

    /***
     * Permutation formula:
     *  permutation = n! = n*(n-1)!
     *  For instance:
     *  Permutation of 3 is 3*2*1 = 6
     */
    public  void permutationSequence(int startIndex){
        if(startIndex ==  arr.length) {
            print();
            permutationNumber++;
        }
        for(int currentIndex = startIndex; currentIndex < arr.length; currentIndex++){
            // exchange the value of arr[currentIndex] with arr[startIndex] at startIndex aka 0
            exchangeIndex(currentIndex,startIndex);
            // enumerate through (N - 1)! number left from arr[startIndex + 1] -> arr[N-1}
            permutationSequence(startIndex + 1);
            // clean up to put the position back
            exchangeIndex(currentIndex,startIndex);
        }
    }

    public long factorial(int N){
        long result = 1;
        for(int n = 1; n <= N;n++) result *= n;
        return result;
    }

    /***
     * P(n,r) = n!/(n-r)!
     */
    public long permutationChoose(int n, int r){
       return factorial(n)/factorial(n-r);
    }


    public static void main(String[] args){
        int n = 3, r = 2;
        Permutation permutation = new Permutation(n);
        System.out.println("The number of permutation is " + permutation.permutationNumber);
        System.out.println("factorial of " + n + " is " + permutation.factorial(n));
        System.out.println("P(" + n + "," + r + ") is " + permutation.permutationChoose(n,r));
    }
}
