package Array;

import java.util.ArrayList;
import java.util.List;

public class threeSum {

    static int[] temp;
    public static  void mergeSort(int[] arr, int lo, int hi){
        if(lo >= hi) return;
        int middle = (hi - lo)/2 + lo;
        mergeSort(arr,lo,middle);
        mergeSort(arr,middle+1,hi);
        merge(arr,lo,middle,hi);
    }

    public static void merge(int[] arr, int lo, int middle, int hi){
        for(int i = lo; i <= hi; i++)temp[i] = arr[i];
        int startLeft = lo, startRight = middle+1;
        for(int i = lo; i <= hi; i++){
            if(startLeft > middle) arr[i] = temp[startRight++];
            else if (startRight > hi) arr[i] = temp[startLeft++];
            else if(temp[startLeft] < temp[startRight]) arr[i] = temp[startLeft++];
            else arr[i] = temp[startRight++];
        }
    }

    public static  List<List<Integer>> threeSum(int[] nums) {
        temp = new int[nums.length];
        List<Integer> pair = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        mergeSort(nums,0,nums.length-1);
        int lo = 0,hi = nums.length - 1;
        while(lo < hi){
            int result = nums[lo] + nums[hi];
            // if result < 0
            if(result < 0){
                if(hi >= 0) result += nums[hi - 1];
                if(result != 0) {
                    if(result < 0)lo++;
                    else hi--;
                    continue;
                }else{
                    pair.add(nums[lo]);
                    pair.add(nums[hi-1]);
                    pair.add(nums[hi]);
                    resultList.add(pair);
                    pair = new ArrayList<>();
                }
                hi--;
                // if result > 0
            }else if(result > 0){
                result += nums[lo+1];
                if(result != 0) {
                    if(result < 0)lo++;
                    else hi--;
                    continue;
                }else{
                    pair.add(nums[lo+1]);
                    pair.add(nums[lo]);
                    pair.add(nums[hi]);
                    resultList.add(pair);
                    pair = new ArrayList<>();
                }
                lo++;
                //if result == 0
            }else{
                if(nums[lo + 1] == 0){
                    if(lo + 1 == hi ){
                        lo++;
                        continue;
                    }
                    pair.add(nums[lo+1]);
                    pair.add(nums[lo]);
                    pair.add(nums[hi]);
                    resultList.add(pair);
                    pair = new ArrayList<>();
                    lo++;
                    while(lo < nums.length && nums[lo] == 0 ) lo++;
                    if(lo >= hi) break;
                }
                else if(nums[hi - 1] == 0){
                    if(hi - 1 == lo || hi == lo){
                        hi--;
                        continue;
                    }
                    pair.add(nums[hi-1]);
                    pair.add(nums[lo]);
                    pair.add(nums[hi]);
                    resultList.add(pair);
                    pair = new ArrayList<>();
                    hi--;
                    while(hi > 0 && nums[lo] == 0 ) hi--;
                    if(hi < 0) break;
                }
            }
        }

        return resultList;

    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> list: result){
            for(int num: list) System.out.print(num +",");
            System.out.println();
        }

    }
}
