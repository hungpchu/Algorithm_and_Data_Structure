package Sorting;

public class Search_in_Rotated_Sorted_Array {

    public static int binaryModify(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while( lo <= hi){
            int midd = (hi - lo)/2 + lo;
            if(nums[midd] == target) return midd;
            int closeL = Math.abs(target - nums[lo]);
            int closeR = Math.abs(target - nums[hi]);
            if (closeL < closeR) hi = midd - 1;
            else if (closeL > closeR) lo = midd + 1;
            else if (closeL == closeR){
                if(nums[lo] < target)  hi = midd - 1;
                    else lo = midd + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums1 = {5,6,7,0,1,2,4};
        int[] nums2 = {6,7,0,1,2,4,5};
        int[] nums3 = {1,2,4,5,6,7,0};
        int[] nums4 = {2,4,5,6,7,0,1};
        int[] nums5 = {0,1,2,4,5,6,7};
        int[] nums6 = {7,6,5,4,3,1,0};

        System.out.println(binaryModify(nums,4));
        System.out.println(binaryModify(nums,3));
        System.out.println(binaryModify(nums4,4));
        System.out.println(binaryModify(nums6,3));
    }
}
