package combinationSearch.Backtracking;


import java.util.HashMap;


/***
 * Time: O(5^L) with L is the length of N  -> 5 is the base since there are only 5 number who can rotate 180
 * Space:O(N) with N is the size of arr and hm
 */
public class confusingNumber {

    public static int count;
    public static int[] arr = {0,1,6,8,9};
    public static HashMap<Character,Character> hm;



    public static int countConfusing(int N){
        count = 0;
        hm = new HashMap<>();
        hm.put('0','0');
        hm.put('1','1');
        hm.put('6','9');
        hm.put('8','8');
        hm.put('9','6');
        long newN = N;
        dfs(0,newN);
        return count;
    }

    // check like palindrome
    // if the rotate number = original number then not include
    public static boolean isValid(long num){
        if(num == 0|| num == 1 || num == 8) return false;
        String numString = String.valueOf(num);
        for(int i = 0; i <= numString.length()/2;i++){
            if(numString.charAt(i) != hm.get(numString.charAt(numString.length() - 1 - i ))) return true;
        }
        return false;
    }

    public static void dfs(long num,long N){
      if(isValid(num)) count++;
      System.out.println(" num = " + num);
      // iterate through the whole array of base 15
      for(int i = 0; i < arr.length;i++){
          // if the number = 0 and we are at index 0 then arr[0] = 0
          // -> we will be in the infinity loop of number = 0 if we are not continue
          if(i == 0 && num == 0) continue;
          long valid = num*10 + arr[i];
          // if valid number > N then continue to check new permutation
          if(valid > N) continue;
          dfs(valid,N);
      }
    }


    public static void main(String[] args){
        System.out.print("count = " + countConfusing((int)Math.pow(10,2)));
    }
}
