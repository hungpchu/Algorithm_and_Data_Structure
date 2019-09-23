package String;

public class reverseCharOnly {
    public static String  reverse(String s){
        if( s.length() == 0 || s.length() == 1) return s;
        char[] ch = s.toCharArray();
        int l = 0, h = s.length() - 1;

        while(l < h){
            while(!Character.isAlphabetic(s.charAt(l))) l++;
            while(!Character.isAlphabetic(s.charAt(h))) h--;
            ch[l] = s.charAt(h);
            ch[h] = s.charAt(l);
            h--;
            l++;
        }
         String output = new String(ch);
        return output;
    }

    public static void main(String[] args){
        System.out.print(reverse("ab-----------------------cdfg-"));
        System.out.print(false && false && false);
    }
}
