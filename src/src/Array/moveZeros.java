package Array;

public class moveZeros {
    //time: O(n)
    // space: O(1)
    // using 2 pointer from the start
    public static void moveZeroes(int[] nums) {
        // base case: the lenght == 0 return
        if (nums.length == 0) return;
        // put 2 pointer start at the same position
        int slow = 0, fast = 0;
        // loop til fast is done
        while(fast < nums.length){
            // if fast == length or slow == length then return
            if(fast == nums.length || slow == nums.length) return;
            // slide slow to the first 0 in the array
            while(nums[slow] != 0){
                slow++;
                fast++;
                // if the slow == length then return
                if(slow == nums.length) return;
            }
            // slide fast to the first non-0 number after first 0
            while(nums[fast] == 0){
                fast++;
                // if fast == length then return
                if(fast == nums.length) return;
            }
            // if num at fast is not 0 then swap with the num at slow position of the beginning list of 0
            if(nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            // increase fast
            fast++;
        }
    }

    public static void main(String[] args){
        int[] arr = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(arr);
        System.out.print("{");
        for(int n: arr) System.out.print( n + ",");
        System.out.print("}");

    }
}
