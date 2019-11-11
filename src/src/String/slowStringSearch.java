package String;

public class slowStringSearch {

    /***
     * brute force
     * time: O(NM)
     * @param pattern
     * @param text
     * @return
     */
    public static String search(String pattern, String text){
        for(int i = 0; i < text.length() - pattern.length() + 1; i++){
            int j;
            for(j = 0; j < pattern.length();j++){
                if(text.charAt(i+j) != pattern.charAt(j)) break;
            }
            // found if we not break in the loop above and j reach the end of pattern
            if(j == pattern.length()) return text.substring(i,i+pattern.length());
        }
        return text;
    }

    public static void main(String[] args){
        String text = "hunghunuguhungchugep";
        String pattern = "hungchu";
        System.out.println("pattern = " + search(pattern,text));
    }
}
