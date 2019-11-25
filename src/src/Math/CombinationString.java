package Math;

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac CombinationsK.java
 *  Execution:    java CombinationsK n k
 *
 *  Enumerates all subsets of size k on n elements in lexicographic order.
 *  Two different solutions. Uses some String library functions.
 *
 *  % java CombinationsK 5 3
 *  abc
 *  abd
 *  abe
 *  acd
 *  ace
 *  ade
 *  bcd
 *  bce
 *  bde
 *  cde
 *
 ******************************************************************************/

public class CombinationString {

    // print all subsets that take k of the remaining elements, with given prefix
    public  static void comb1(String s, int k) { comb1(s, "", k); }
    private static void comb1(String s, String prefix, int k) {
        if (s.length() < k) return;
        else if (k == 0) StdOut.println(prefix);
        else {
            comb1(s.substring(1), prefix + s.charAt(0), k-1);
            comb1(s.substring(1), prefix, k);
        }
    }


    // print all subsets that take k of the remaining elements, with given prefix
    public  static void comb2(String s, int k) { comb2(s, "", k); }
    private static void comb2(String s, String prefix, int k) {
        if (k == 0) StdOut.println(prefix);
        else {
            for (int i = 0; i < s.length(); i++)
                comb2(s.substring(i + 1), prefix + s.charAt(i), k-1);
        }
    }

    // reads in two integer command-line arguments n and k and
    // print all subsets of size k from n elements
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        String alphabet = "123456789";
        String elements = alphabet.substring(0, n);

        comb1(elements, k);
        StdOut.println();
        comb2(elements, k);
    }

}


