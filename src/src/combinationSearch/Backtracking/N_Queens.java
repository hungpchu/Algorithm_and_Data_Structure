package combinationSearch.Backtracking;

/***
 * Constraint: No diagonal attack
 */
public class N_Queens  {
    public static  int[] arr;
    public static int queenPlacement;

    // check for the diagonal so that queen not attacks each other
    public static boolean backtrack(int position){
        for(int i = 0 ; i < position; i++){
            if(arr[i] - arr[position] == position - i){
//                System.out.println("i - pos = " + (i - position));
                return true;
            }
            if(arr[position] - arr[i] == position - i){
//                System.out.println("position - i = " + (position - i));
                return true;
            }
        }
        return false;
    }

    /***
     * Permutation formula:
     *  permutation = n! = n*(n-1)!
     *  For instance:
     *  Permutation of 3 is 3*2*1 = 6
     */
    public  static void permutationSequenceOfQueen(int startIndex){
        if(startIndex ==  arr.length) {
            print();
            queenPlacement++;
        }
        for(int currentIndex = startIndex; currentIndex < arr.length; currentIndex++){
            // exchange the current position with first Index aka 0
            exchangeIndex(currentIndex,startIndex);
            // enumerate through (N - 1)! number left
            if(!backtrack(startIndex))permutationSequenceOfQueen(startIndex + 1);

            // clean up to put the position back
            exchangeIndex(currentIndex,startIndex);
        }
    }

    public static void print(){
        for(int i = 0; i < arr.length; i++ )System.out.print(arr[i] +" ");
        System.out.println();
    }

    // swap the currentIndex into the startPosition aka 0
    public static void exchangeIndex(int startIndex,int currentIndex){
        int temp = arr[startIndex];
        arr[startIndex] = arr[currentIndex];
        arr[currentIndex] = temp;
    }

    public static void main(String[] args){
        int queen = 8;
        arr = new int[queen];
        for(int i = 0; i < queen; i++) arr[i] = i;
        permutationSequenceOfQueen(0);
        System.out.println("number of queen placement = "+ queenPlacement);
    }
}
