package Math;

public class Hex_Decimal {

    public static int stringToDecimal(String s){
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            // *10 since decimal is base 10
            num = num * 10 + (s.charAt(i) % '0');
        }
        return num;
    }

    public static int hexToDecimal(String hex){
        String hexElement = "0123456789ABCDEF";
        hex = hex.toUpperCase().trim();
        int result = 0;
        for(int i = 0; i < hex.length(); i++){
            // retrieve the hex index from the string;
            int hexIndex = hexElement.indexOf(hex.charAt(i));
            // *16 since hex is base 16
            result = result*16 + hexIndex;
        }
        return result;
    }

    public static String decimalToHex(int decimal){
        String hexElement = "0123456789ABCDEF";
        String result = "";
        while(decimal > 0){
            // retrieve number with base 16
            int lastNum = decimal % 16;
            // reverse from FA to AF
            result = hexElement.charAt(lastNum) + result;
            // shrink the decimal gradually to 0
            decimal = decimal / 16;
        }
        return result;
    }

    // Link to ASCII table: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
    public static void main(String[] args){
        System.out.println(stringToDecimal("12345"));
        System.out.println(hexToDecimal("af"));
        System.out.println(decimalToHex(175));
        char[] a = new char[256];
        char theChar = 'a';
        int count = 0;
        a[theChar] = 'l';
        for(int i = 0; i < a.length;i++){
            if(a[i] == 'l') break;
            count++;
        }
        System.out.println("size = " + count);
    }
}
