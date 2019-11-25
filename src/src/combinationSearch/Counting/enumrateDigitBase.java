package combinationSearch.Counting;

/***
 * Enumerate all the digit with different base like
 * digit with base 10 or 16
 * Problem: enumerate all N digit base R numbers
 */
public class enumrateDigitBase {

    public static int[] data;
    public static int numberCount;

    public static void enumerateDigitBase(int numberOfDigit, int base){
        // init the array with the number of digit you want with all 0 valuy
        data = new int[numberOfDigit];
        // enumerate with the startPoistion is 0 and base
        enumerateDigitBase(0,numberOfDigit, base);
    }

    /***
     * enumerateDigitBase is permutation with duplicate value
     * @param startPosition is always 0
     * @param numberOfDigit number of digit per row
     * @param base range of number
     */
    public static void enumerateDigitBase(int startPosition, int numberOfDigit, int base){
        // base case
        if(startPosition == numberOfDigit){
            process();
            numberCount++;
            return;
        }
        // loop through array
        for(int number = 0; number < base; number++){
            // place a number in the base range with startPosition is 0
            data[startPosition] = number;
            // increase the startPosition  + 1 for the next number in the base
            enumerateDigitBase(startPosition + 1,numberOfDigit,base);
        }
        //clean up
        data[startPosition] = 0;
    }

    public static void process(){
        for(int num: data) System.out.print(num +" ");
        System.out.println();
    }

    public static void permutationDuplicate(int N){
        for(int i = 1; i < N; i++) System.out.print(i +" ");
    }

    public static void main(String[] args){
        int numberOfDigit = 3, base = 10;
        enumerateDigitBase(numberOfDigit,base);
        System.out.println("The number of element with " + numberOfDigit + " digit and base " + base + " is " + numberCount);
        permutationDuplicate(1000);
    }
}
