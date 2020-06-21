package GoogleKickStart;


import java.util.Scanner;
import java.util.Stack;

public class Robot {

    public static void robot(int c, String move)
    {
        if ( move.length() == 0 ) System.out.println("Case  #" + c + ": 1 1" );
        long r = 1L, col = 1L;
        int open = 0;
        Stack<String>  st = new Stack<>();
        for ( int i = 0; i < move.length(); i++ )
        {
                if (move.charAt(i) == ')'){
                    String small = "";
                    while(!st.empty() && !st.peek().equals("(") ) small = small + st.pop();
                    if ( !st.isEmpty()){
                        st.pop();
                        open--;
                    }
                    int number = Integer.parseInt(String.valueOf(st.pop()));
                    String smallM = "";
                    while ( number > 0 )
                    {
                        smallM += small;
                        number--;
                    }
                    st.add(smallM);
                    if ( open == 0 ){
                        for ( int j = 0; j < smallM.length(); j++) {
                            if (smallM.charAt(j) == 'N') {
                                if (r == 1) r = 1000000000L;
                                else r--;
                            } else if (smallM.charAt(j) == 'S') {
                                if (r == 1000000000L) r = 1;
                                else r++;
                            } else if (smallM.charAt(j) == 'E') {
                                if (col == 1000000000L) col = 1;
                                else col++;
                            } else {
                                if (col == 1) col = 1000000000L;
                                else col--;
                            }
                        }
                    }
                }else {
                    st.add(String.valueOf(move.charAt(i)));
                    if ( move.charAt(i) == '(') open++;
                    if ( open == 0 && Character.isLetter(move.charAt(i))){
                        if ( move.charAt(i) == 'N'){
                            if ( r == 1 ) r = 1000000000L;
                            else r--;
                        }
                        else if ( move.charAt(i) == 'S'){
                            if ( r == 1000000000L ) r = 1;
                            else r++;
                        }
                        else if ( move.charAt(i) == 'E'){
                            if  ( col == 1000000000L ) col = 1;
                            else col++;
                        }
                        else {
                            if ( col == 1 ) col = 1000000000L;
                            else col--;
                        }
                    }
                }
        }
        System.out.println("Case #" + c + ": " + col + " " + r);
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int c = 1;
        input.nextLine();
        while (input.hasNext()) {
            robot(c, input.nextLine());
            c++;
        }
    }
}
