package DynamicProgramming;

public class minDiffOf2Subset {

    public static int minDiff(int[] arr){
        int sum = 0;
        for(int num: arr) sum += num;
        boolean[][] sumCheck = new boolean[arr.length + 1][sum+1];

        //init for sum = 0 and number = 0
        for(int i = 0 ; i < arr.length + 1; i++) sumCheck[i][0] = true;


        for(int i = 1; i <= arr.length;i++){
            for(int j = 1; j < sum + 1; j++){
                // if the sum is smaller then current number then take the prev sum
                if(j < arr[i - 1]) sumCheck[i][j] = sumCheck[i-1][j];
                else{
                    // if the above is true then now is true
                    if(sumCheck[i-1][j]) sumCheck[i][j] = sumCheck[i-1][j];
                    // else check the prev sum
                    else sumCheck[i][j] = sumCheck[i-1][j-arr[i-1]];
                }
            }
        }

//        for(int i = 0; i <= arr.length;i++){
//            for(int j = 0; j < sum + 1; j++){
//                System.out.print(sumCheck[i][j] + " ");
//            }
//            System.out.println();
//        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum/2 ;i++){
            if( sumCheck[arr.length][i] ){
                int otherSum = sum - i;
                if(Math.abs(otherSum - i) != 0 && min > Math.abs(otherSum - i)) min = Math.abs(otherSum - i);
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] arr = {1,6,11,5};
        System.out.println("min difference of 2 subset is " + minDiff(arr));
    }
}
