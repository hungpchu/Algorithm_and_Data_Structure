package GoogleKickStart.roundC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class candies {

    public static void candy ( List<Integer> l, List<String> query, int c)
    {
        int score = 0;
        for ( int i = 0; i < query.size(); i++ )
        {
            String[] q = query.get(i).split(" ");
            if (q[0].equals("U")) l.set(Integer.parseInt(q[1]) - 1, Integer.parseInt(q[2]));
            else{
                int mul = 1;
                for ( int j = Integer.parseInt(q[1]) - 1; j <= Integer.parseInt(q[2]) - 1; j++ )
                {
                    if ( mul == 2) score -= mul*l.get(j);
                    else score += mul*l.get(j);
                    mul++;
                }
            }
        }

        System.out.println("Case #"+ c + ": " + score );
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int c = 1,check = 1, number = 0;
        input.nextLine();
        while (input.hasNext()) {
            if (check % 2 == 0)
            {
                List<Integer> list = new ArrayList<>();
                String s = input.nextLine();
                String[] sC = s.split(" ");
                for (String st : sC) list.add(Integer.parseInt(st));
                List<String> l = new ArrayList<>();
                for(int i = 0; i < number; i++) l.add(input.nextLine());
                candy(list,l,c);
                number = 0;
                c++;
            }else{
                String s = input.nextLine();
                String[] sC = s.split(" ");
                number = Integer.parseInt(sC[1]);
            }
            check++;
        }
    }
}
