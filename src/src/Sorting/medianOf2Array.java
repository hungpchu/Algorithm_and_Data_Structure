package Sorting;

public class medianOf2Array {
    public static int median1, median2;

    public static int getMedianIndex(int[] arr, int lo, int hi,int median){
        int medianIndex = partition(arr,lo,hi,median);
        while(median != medianIndex){
            if(lo >= hi) break;
            medianIndex = partition(arr,lo,hi,median);
            if(medianIndex < median) lo = medianIndex + 1;
            else if (medianIndex > median) hi = medianIndex - 1;
        }
        return arr[medianIndex];
    }

    public static void selectMedian(int[] arr, int median){
        int lo = 0, hi = arr.length - 1;
        int[] secondArr = arr;
        int medianIndex = partition(arr,lo,hi,median);
        while(median != medianIndex){
            if(lo >= hi) break;
             medianIndex = partition(arr,lo,hi,median);
            if(medianIndex < median) lo = medianIndex + 1;
            else if (medianIndex > median) hi = medianIndex - 1;
        }
        median1 = arr[median];
        int otherMedian = median - 1;
        lo = 0;
        hi = secondArr.length - 1;
        if(otherMedian >= 0 && arr.length % 2 == 0 ){
            medianIndex = partition(secondArr,lo,hi,otherMedian);
            while(otherMedian != medianIndex){
                if(lo >= hi) break;
                medianIndex = partition(secondArr,lo,hi,otherMedian);
                if(medianIndex < otherMedian) lo = medianIndex + 1;
                else if (medianIndex > otherMedian) hi = medianIndex - 1;
            }
            median2 = arr[otherMedian];
        }
    }

    public static void exchange(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static  int partition(int[] arr, int lo, int hi, int median){
        int left = lo+1,  right = hi , pivot = arr[lo];
        while(true){
            while(left <= hi && arr[left] <= pivot){
                left++;
                if(left >= hi ) break;

            }
            while(right >= lo && arr[right] >= pivot){
                right--;
                if(right <= lo ) break;
            }
            if(left >= right || right < 0) break;
            exchange(arr,left,right);
        }
        if(right >= 0 ) exchange(arr,lo,right);
        return right;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        double median =0;
        int[] nums = new int[length];

            int count = 0;
            for (int i = 0; i < nums1.length; i++) {
                nums[i] = nums1[i];
                count++;
            }

            for (int i = 0; i < nums2.length; i++) {
                nums[count] = nums2[i];
                count++;
            }
        int medianPosition = nums.length/2;
        selectMedian(nums,medianPosition);
        if(nums.length % 2 == 0) median = (double) (median1 + median2)/2;
        else median = median1;
        return median;

    }

    /***
     * time:O(log(m+n))
     * space:O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public  double findMedianSortedArraysIteration(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        // nums1Length > nums2Length then (nums1Length + nums2Length + 1)/2 - nums2Length may be negative
        if(nums1Length >  nums2Length){
            // swap leftArray to be rightArray
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            // swap leftLength to be rightLength
            int tem = nums1Length;
            nums1Length = nums2Length;
            nums2Length = tem;
        }

        // System.out.println("nums2 size = " +nums2.length);

        // retrieve the value of endNums1 and startNums1
        int startNums1 = 0, endNums1 = nums1Length;
        // halfLength will help balance 2 side of half lef(nums1 and nums2) and halfright(nums1 and nums2)
        int halfLength = (nums1Length + nums2Length + 1)/2;

        while(startNums1 <= endNums1){
            // now we have pivot of both num1 and num2 in the position that
            // both length(left(num1))  + length(left(num2)) == length(right(num1)) +length(right(num2))
            int nums1Pivot = (startNums1 + endNums1)/2 ;
            int nums2Pivot = halfLength - nums1Pivot;
            // if the last number of left in nums1 > first number of right side in nums2
            // -> then shrink the left side by decrese endNums1
            if(nums1Pivot > startNums1 && nums1[nums1Pivot - 1] > nums2[nums2Pivot]) endNums1 = nums1Pivot - 1;
                // make sure nums2Pivot is not over length of nums2
                // if the last number of left in nums2 > the first number of right in nums1
                // then expand the right side by increase the startNums1
            else if(nums1Pivot < endNums1 && nums2[nums2Pivot - 1] > nums1[nums1Pivot]) startNums1 = nums1Pivot + 1;
                // if the nums1[nums1Pivot - 1] < nums2[nums2Pivot] and nums2[nums2Pivot] < nums1[nums1Pivot]
            else{
                int maxLeft = 0;
                if(nums1Pivot  == 0 ) maxLeft = nums2[nums2Pivot - 1];
                else if(nums2Pivot == 0 ) maxLeft = nums1[nums1Pivot - 1];
                else maxLeft = Math.max(nums2[nums2Pivot-1],nums1[nums1Pivot-1]);
                // if the sum of length of 2 array is odd then return maxLeft
                if( (nums1Length + nums2Length) % 2 != 0 ) return maxLeft;

                int minRight = 0;
                if(nums1Pivot == nums1Length) minRight = nums2[nums2Pivot];
                else if(nums2Pivot == nums2Length) minRight = nums1[nums1Pivot];
                else minRight = Math.min(nums1[nums1Pivot], nums2[nums2Pivot]);

                return (minRight + maxLeft)/2.0;

            }

        }
        return 0.0;
    }

    public static void main(String[] args){
        int[] nums1 = {};
        int[] nums2 = {2,3};
        System.out.println("median = " + findMedianSortedArrays(nums1,nums2));

    }
}
