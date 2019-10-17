package GoogleInterviewPractice;

public class maximumTime {

    // time:O(1)
    // space:O(n) to modify the result
    public static String maximumTime(String input){
        char[] inputArray = input.toCharArray();
        int i = 0;

        if( input.charAt(0) == '?' ){
            if( input.charAt(1) == '?') {
                inputArray[0] = '2';
                inputArray[1] = '3';
            }else{
                int num1 = Character.getNumericValue(inputArray[1]);
                if(num1 >= 4 && num1 <= 9) inputArray[0] = '1';
                else inputArray[0] = '2';
            }
         // first num is the number
        }else {

            if (input.charAt(1) == '?') {

                int num0 = Character.getNumericValue(inputArray[0]);
                if (num0 == 2) inputArray[1] = '3';
                else inputArray[1] = '9';

            }
        }
        if( input.charAt(3) == '?'){
            if( input.charAt(4) == '?') {
                inputArray[3] = '5';
                inputArray[4] = '9';
            }else{
                int num4 = Character.getNumericValue(inputArray[4]);
                if(num4 >= 4 && num4 <= 9) inputArray[3] = '1';
                else inputArray[3] = '2';
            }

        }else{
            if (input.charAt(4) == '?') {

                int num3 = Character.getNumericValue(inputArray[3]);
                if (num3 == 2) inputArray[4] = '3';
                else inputArray[4] = '9';

            }

        }


        return String.valueOf(inputArray);
    }

    public static void main(String[] args){
        String time = "??:??";
        String time1 = "?3:??";
        String time2 = "1?:??";
        String time3 = "20:??";
        String time4 = "??:2?";
        String time5 = "??:?9";
        String time6 = "??:01";
        String time7 = "1?:00";
        String time8 = "0?:??";
        String time9 = "2?:22";
        String time10 = "?4:5?";


        System.out.println("Max time = "+ maximumTime(time10));
    }
}
