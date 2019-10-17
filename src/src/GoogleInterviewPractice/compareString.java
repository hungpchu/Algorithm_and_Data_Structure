package GoogleInterviewPractice;

import java.util.Arrays;

public class compareString {

    public static int[] compareString(String A, String B){
        // base case if both A and B has length 0 then return
        if (B.length() == 0 && A.length() == 0) return new int[0];
        String[] wordOfA = A.split(",");
        String[] wordOfB = B.split(",");
        // result for returning
        int[] result = new int[wordOfB.length];

        // loop through array of word in string A to obtain number frequency of first letter of each word
        int inA = 0;
        int[] Alength = new int[wordOfA.length];
        for(String sA: wordOfA){
            int count = 1,i = 0;
            while(i < sA.length() - 1 && sA.charAt(i) == sA.charAt(i+1)){
                i++;
                count++;
            }
            Alength[inA] = count;
            inA++;
        }

        // loop through array of word in string B to obtain number frequency of first letter of each word
        int inB = 0;
        int[] Blength = new int[wordOfB.length];
        for(String sB: wordOfB){
            int count = 1,i = 0;
            while(i < sB.length() - 1 && sB.charAt(i) == sB.charAt(i+1)){
                i++;
                count++;
            }
            Blength[inB] = count;
            inB++;
        }
//        System.out.println("B = ");
//        for(int n: Blength) System.out.print(n+",");
//        System.out.println();
//        System.out.println("A = ");
//        for(int n: Alength) System.out.print(n+",");
//        System.out.println();
        // using merge sort to sort array A
        Arrays.sort(Alength);
        int inRe = 0;
        for(int blength: Blength){
            int first = 0,last = Alength.length - 1;
            int bigger = 0;
            if(blength > Alength[last]) result[inRe] = Alength.length;
                else {
                while (first < A.length() && blength > Alength[first]) {
//                    if (blength == Alength[first]) break;
                    first++;
                    bigger++;
                }
                //   System.out.println("bigger = "+ bigger);
                result[inRe] = bigger;
            }
            inRe++;
        }

        return result;
    }

    public static void main(String[] args){
        String A =  "abcd,aabc,bd";
        String B = "aaa,aa";
        String C =  "abcd,aaaa,bd";
        String D  = "bbb,b";
        for(int n: compareString(C,D))System.out.print(n+",");
    }
}
