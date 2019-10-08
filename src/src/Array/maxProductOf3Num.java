package Array;

public class maxProductOf3Num {
    int[] temp;

    public void sort(int[] a){
        temp = new int[a.length];
        mergeSort(a,0,a.length - 1);
    }

    public void mergeSort(int[] a,int l, int r){
        if(l >= r) return;
        int m = (r - l)/2 + l;
        mergeSort(a,l,m);
        mergeSort(a,m + 1,r);
        merge(a,l,m,r);
    }

    public void merge(int[]a ,int l, int m, int r){

        for(int i = l; i <= r; i++) temp[i] = a[i];

        int middleL = l, middleR = m + 1;
        for(int i = l; i <= r; i++){
            if(middleL > m) a[i] = temp[middleR++];
            else if(middleR > r) a[i] = temp[middleL++];
            else if(temp[middleL] < temp[middleR]) a[i] = temp[middleL++];
            else  a[i] = temp[middleR++];
        }
    }


    // time:O(nlogn) with sorted array using merge sort
    // space: O(1)
    public int maximumProduct(int[] nums) {
        // base case if the length less then 3 then no result at all
        if (nums.length < 3) return 0;
        // sort using merge sort implemented by Hung Chu
        sort(nums);
        int endNegative = 0, end = nums.length - 1, count = 0, result = 1, maxPositive = 1, maxNegative = 1;
        // Arrays.sort(nums);
        // find the end of negative number and the start of positve number
        while(endNegative <= end  && nums[endNegative] < 0) endNegative++;

        int startPositive = endNegative;
        int startNegative = 0;
        // maxPositive = product of 2 last element before last element of positive number
        if(0 <= end - 2) maxPositive *= nums[end - 1] * nums[end - 2];
        // maxNegative = product of 2 first negative number
        if(startNegative <= end - 1) maxNegative *= nums[startNegative] * nums[startNegative + 1];
        // result will take the max between maxNegative and maxPositive
        result *= nums[end] * Math.max(maxNegative,maxPositive);
        return result;
    }
}
