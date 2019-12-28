package Array;

public class nextGreaterElement {
    // nums1 is the subset of nums2
    // brute force
    // time: O(m*n) with n is the size of main set
    // space: O(m) with m is the size of the subset
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        int in = 0;
        for(int n: nums1){
            int max = 999;
            for(int i = nums2.length-1; i >= 0; i--){
                if(nums2[i] > n) max = nums2[i];
                if(nums2[i] == n) break;

            }
            if(max == 999) res[in] = -1;
            else res[in] = max;
            in++;

        }

        return res;
    }

    public static void main(String[] args){

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] nums3 = {2,4};
        int[] nums4 = { 1,2,3,4};
        for(int n: nextGreaterElement(nums3,nums4)) System.out.print(n + " ");
    }
}
