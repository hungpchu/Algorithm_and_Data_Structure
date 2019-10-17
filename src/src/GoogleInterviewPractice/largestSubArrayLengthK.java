package GoogleInterviewPractice;

public class largestSubArrayLengthK {

    public static int[] largestSubArray(int[] a, int K){
        int[] result = new int[K];
        int i = 0;
        int maxStart = 0;
        while( i < a.length){
            while(a[maxStart] < a[i] && i + K <= a.length){
                maxStart = i;
                i++;
            }
            i++;
        }
        System.out.println("maxStart = "+ maxStart);
        int in = 0;
        for( i = maxStart; i < maxStart + K ; i++){
            result[in] = a[i];
            in++;
        }

        return result;
    }

    public static void main(String[] args){
        int[] a = {1,5,6,8,7,10};
        int[] a1= {1,4,3,2,5};
        int[] a2 = {4,3,25,4,2,3,4,5,78,9};
        int K = 3,K1 = 4,K2 = 2;
        for(int n: largestSubArray(a2,K2) ) System.out.print(n+",");
    }
}
