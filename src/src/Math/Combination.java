package Math;

public class Combination {

    /***
     * Calculate the combination of C(n,r)
     * C(n,r) = n*...(n-r+1)/
     */
    public static long combination(int number, int choosenNumber){
        if(choosenNumber < 0) return 0;
        long result = 1;
        for(int r = 1; r <= choosenNumber;r++){
            // multiply n*...*n - r + 1
            result *= number - r + 1;
            // divide with r*..*1
            result /= r;
        }
        return result;
    }

    public static void  combinationFixedChoose2(int number){
        System.out.println("List of combination of C(" + number + ",2) is " );
        for(int i = 1; i <= number; i++){
            for(int j = i + 1; j <= number; j++) System.out.println(i + "," + j + "," );
        }
    }

    public static void  combinationFixedChoose3(int number){
        System.out.println("List of combination of C(" + number + ",2) is " );
        for(int i = 1; i <= number; i++){
            for(int j = i + 1; j <= number; j++)
                for(int z = j + 1; z <= number; z++) System.out.println(i + "," + j + "," + z);
        }
    }

    public static void combinationIteration(int number, int choosenNumber){
        if(choosenNumber == 0) return;
        int[] combination = new int[choosenNumber];
        // init all the number element in the combination array
        for(int num = 0; num < choosenNumber; num++) combination[num] = num;
        // index set to the last element in the set from r to n to keep track of max
        int index = choosenNumber -1;
        // terminate number = number - choosenNumber + 1 since we are out of range of index number which is choosenNumber
        int terminateNumber = number - choosenNumber + 1;

        // if the first position number are out of range then exit while loop
        while(combination[0] < terminateNumber){
            // max indicate the max number in combination we can get in the range of r to n before we will be out of range
             int max = number - choosenNumber + index;
             // if the last number at combination = max then it is about to go out of range
            while(index > 0 && combination[index] == max){
                //-> we should deduct the index by 1 until the element are not go out of range
                index--;
                // update the max
                max = number - choosenNumber + index;

            }
            for(int i = 0; i < choosenNumber;i++) System.out.print(combination[i] + ",");
            System.out.println();
            // reset the value at index to include new number inside the combination
            combination[index]++;
            // update all element when index are set back to smaller
            while(index < choosenNumber -1) {
                combination[index + 1] = combination[index] + 1;
                index++;
            }
        }
    }

    public static void combinationRecursive(int n, int r){
        int[] combination = new int[r];
        // element in the combination will be in range of 0 to r+1
        combinationRecursive(combination,0,r+1,0);
    }

    /***
     *  C(n,r) = C(n-1,r-1) + C(n-1,r)
     *  Bottom up recursive:
     *  C(n-1,r-1) include the first item
     *  C(n-1,r) exclude the 1st item
     */
    public static void combinationRecursive(int[] combination, int start, int end, int index){
        // index will be in range of r
        if(index == end - 1){
            for(int num: combination) System.out.print(num +",");
            System.out.println();
        }else if(start <= end){
            combination[index] = start;
            // include the index
            combinationRecursive(combination,start + 1, end, index+1);
            // exclude the index
            combinationRecursive(combination,start+1,end,index);
        }
    }



    public static void main(String[] args){
        int n = 3,r =2;
        System.out.println("C("+n + "," + r + ") is " + combination(n,r));
      //  combinationFixedChoose2(n);
//        combinationIteration(n,r);
        combinationRecursive(n,r);
    }
}
