package String;

public class string_operation {

    public static void main(String[] args){
        String numString = "123";
        char[] numChar = numString.toCharArray();

        int num = Integer.getInteger(numString);
        for(char c: numChar){
            System.out.println(c + " ");
            int numCharac = Character.getNumericValue(c);
        }
    }
}
