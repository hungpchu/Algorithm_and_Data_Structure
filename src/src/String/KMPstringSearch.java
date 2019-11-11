package String;

public class KMPstringSearch {

    public static int KMPsearch(String pattern, String text){
        int[] longestPrefix = new int[pattern.length()];
//        computeLongestPrefix(pattern,longestPrefix);
        computeLPSArray(pattern,pattern.length(),longestPrefix);
        for(int num: longestPrefix) System.out.println(num+",");
        return 1;
    }

    // look like dynamic programming
    public static void computeLongestPrefix(String pattern, int[] longestPrefix){
        int prefixLength = 0;
        // index of char at 1
        int index = 1;
        // at prefixLength = 0 then longestPrefix = 0
        longestPrefix[prefixLength] = 0;
        while(index < pattern.length()){
            if(pattern.charAt(index) == pattern.charAt(prefixLength)){
                prefixLength++;
                longestPrefix[index] = prefixLength;
                index++;
             // pattern.charAt(index) != pattern.charAt(prefixLength)
            }else{
                // if prefixLength != 0 then take the length of previous length
                if(prefixLength != 0) prefixLength = longestPrefix[index - 1];
                else {
                    longestPrefix[index] = prefixLength;
                    index++;
                }
            }
        }
    }


    public static void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args){
        String pattern = "aaacaaaaacaaaa";
        KMPsearch(pattern,"");
    }

}
