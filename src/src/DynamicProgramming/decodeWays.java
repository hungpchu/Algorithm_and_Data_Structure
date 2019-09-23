package DynamicProgramming;

public class decodeWays {
    public static  int numDecodings(String s) {

        int[] dc = new int[s.length() + 1];
        dc[0] = 1;
        dc[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < s.length() + 1; i++){
            int oneDigit = Integer.valueOf(s.substring(i-1,i));
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            // if the previous 1 digit is in the range then take the whole number before this 1 digit
            if(oneDigit > 0)dc[i] += dc[i - 1];
            // if the previous 2 digit is not in the range then take the whole number before this 2 digit
            if(twoDigit >= 10 && twoDigit <= 26)  dc[i] += dc[i - 2];
        }
        return dc[s.length()];
    }

    public static void main(String[] args){
        String a = "123454";
       System.out.println(numDecodings(a));

    }
}
