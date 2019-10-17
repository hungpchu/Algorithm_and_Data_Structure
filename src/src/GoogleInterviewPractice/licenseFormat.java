package GoogleInterviewPractice;

public class licenseFormat {

    // time: O(n)
    // space: O(n)
    public String solution(String S, int K) {
        StringBuilder result = new StringBuilder();
        int i = S.length() - 1,count = 0;
        while( i >= 0){
            char c = S.charAt(i);
            // if c is the '-' then skip
            if( c != '-'){
                result.insert(0,c);
                count++;
                if(count == K ){
                    while(i >= 1 && S.charAt(i - 1) ==  '-') i--;
                    if(i == 0) return result.toString().toUpperCase();
                    result.insert(0,'-');
                    count=0;
                }
                i--;
            }else i--;
        }
        // return stringBuilder as the upperCase string
        return result.toString().toUpperCase();
    }
}
