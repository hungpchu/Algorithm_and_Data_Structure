package Array;

/***
 * Description: https://leetcode.com/discuss/interview-question/387124/Microsoft-or-Onsite-or-Maximum-Spliced-Array
 * Time: O(N)
 * Space:O(N)
 */
public class maxSumArray {
    public static  int[] maxSumArray(int[] a,int[] b){
        int curr = a[0] - b[0], startIn = 0, count = 0, i = 0, sumA = 0, sumB = 0;
        int[] oldB = b.clone();
        // check a - b
        for( i = 1; i < a.length;i++){
            if(curr < 0){
                curr = 0;
                startIn = i;
                count = 0;
            }
            curr += a[i] - b[i];
            if(count == 0) startIn = i;
            count++;
        }

        for( i = startIn; i < startIn  + count; i++)b[i] = a[i];

        for(int n: b) sumB += n;

        startIn = 0;
        count = 0;
        curr = oldB[0] - a[0];
        // check b -a
        for(i = 1; i < b.length;i++){
            if(curr < 0){
                curr = 0;
                startIn = i;
                count = 0;
            }
            curr += oldB[i] - a[i];
            if(count == 0) startIn = i;
            count++;
        }

        for( i = startIn; i < startIn + count; i++)a[i] = oldB[i];

        for(int n: a) sumA += n;

        if(sumA > sumB) return a;
        return b;
    }

    public static void main(String[] args){
        int[] a = {20,40,20,70,30};
        int[] b = {50,20,50,40,20};
        // result
        for(int n: maxSumArray(a,b)) System.out.print(n+" ");
    }
}
