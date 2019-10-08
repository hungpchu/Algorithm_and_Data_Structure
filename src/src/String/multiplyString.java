package String;

public class multiplyString {


    public static int charToInt(char c){ return c - '0'; }

    public static String multiply(String num1, String num2) {
        /***
         * base case: if the other string is empty then return non empty string
         */
        if (num1.length() == 0) return num2;
        if(num2.length() == 0) return num1;
        // temp is the array store the result of num1 and num2 in the reverse order
        int[] temp = new int[num1.length() + num2.length()];
        // stringbuilder to add all the element of temp in string form
        StringBuilder result = new StringBuilder();
        // loop through both num1 and num2 in the reverse order since we have to multiply in the reverse order too
        for(int i = num1.length() - 1; i >= 0; i--){
            // extra is the number to store extra number from previous calculation
            int extra = 0;
            for(int j = num2.length() - 1;j >= 0;j--){
                // num is the product of each single number of num1 and num2 plus the extra
                int num = charToInt(num1.charAt(i)) * charToInt(num2.charAt(j)) + extra;
                // extra is the first number in the num
                extra = num / 10;
                // if num + value in temp has 2 digit
                if(temp[i+j+1] + num > 9){
                    // extract first digit for extra
                    extra =  (temp[i+j+1]+num)/ 10;
                    // extract 2nd digit for value of temp
                    temp[i+j+1] = (temp[i+j+1] + num ) % 10 ;
                }
                // if the num + value has only 1 digit
                else{
                    temp[i + j  + 1] += num;
                }
                // check if at the end of each calculation between each number in num1 with the whole num1 if there is extra digit
                // then store that digit that too
                if(j == 0 && extra > 0) temp[i + j] += extra;

            }
        }
        // check for 0 at the beginning of temp array to find the first index of the number not 0
        int in = 0;
        for(int i = 0; i < temp.length; i++){
            if(temp[i] != 0){
                in = i;
                break;
            }
            in = i;
        }

        // if the index == length of temp then we know that result is 0
        if(in == temp.length) return "0";

        // else add all the element not 0 of beginning to the string builder result
        for(int i = in; i < temp.length; i++) result.append(String.valueOf(temp[i]));
        // convert string builder result to string fi
        String fi = new String(result);
        // return string fi
        return fi;
    }

    public static void main(String[] args){
        String num1 = "99999";
        String num2 = "44444";
        System.out.println("Multiply product of num1 and num2 = " + multiply(num1,num2) );
    }
}
