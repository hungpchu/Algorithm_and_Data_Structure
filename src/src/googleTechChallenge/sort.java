package googleTechChallenge;

import java.util.Arrays;

public class sort {

    public static void main(String[] args){
        String st = "TECHCHALLENGECODINGSPEEDRUN";
        char[] ch = st.toCharArray();
        Arrays.sort(ch);
        for(char c: ch){
            System.out.print(c);
        }
    }
}
