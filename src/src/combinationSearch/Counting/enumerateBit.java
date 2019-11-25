package combinationSearch.Counting;

/***
 * Focus on the bit with base 2 only
 */
public class enumerateBit {
    public static int[] data;

    public static void enumerateBitBase2(int N){
        data = new int[N];
        enumerate(0);
    }

    public static void process(){
        for(int num: data) System.out.print(num +" ");
        System.out.println();
    }

    /***
     * Bottom up post traverse
     * Time: O(2^N) with all the bit number represent from 0 to 2^N
     * Space:O(2^N) with recursive calling stack
     */
    public static void enumerate(int position){
        if(position == data.length){
            process();
            return;
        }
        // print all the start 0 1sr
        enumerate(position + 1);
        // then replace from the end with 1
        data[position] = 1;
        // then print all the 1 at first
        enumerate(position + 1);
        // then print all 0s at the end
        data[position] = 0;
    }

    public static void main(String[] args){
        enumerateBitBase2(4);
    }
}
