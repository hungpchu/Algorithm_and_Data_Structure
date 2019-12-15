package divideAndConquer;

public class trapRainWater {

    // divide and conquer using 2 pointer
    public static int trap(int[] height) {
        int left = 0, right = height.length -1;
        int leftMax = 0, rightMax = 0, total = 0;

        while(left < right){
            // if the left height is smaller -> update
            if(height[left] < height[right]){
                if(height[left] >= leftMax) leftMax = height[left];
                else total += leftMax - height[left];
                left++;
                // if right height is smaller -> update right
            }else{
                if(height[right] >= rightMax) rightMax = height[right];
                else total += rightMax - height[right];
                right--;
            }
        }

        return total;
    }

    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1,0,1};
        System.out.println("heigh = "+trap(height));
    }

}
