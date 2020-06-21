package GoogleKickStart.roundC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class countDown {

    public static void countDown (int c, List<Integer> list, int k)
    {
        if ( list.size() == 0 ) System.out.println("Case #"+ c + ": " + 0 );
        int count = 0, i = 0;

        while (i < list.size())
        {
            if(list.get(i) == k)
            {
                int  startI = i;
                while (i+1 < list.size() && list.get(i+1) + 1 == list.get(i) && list.get(i) >= 1) {
                    i++;
                }
                if (i - startI + 1 == k ) count++;
            }
            i++;
        }
        System.out.println("Case #"+ c + ": " + count );

    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int c = 1, k = 0, check = 0;
        input.nextLine();
        while (input.hasNext()) {
            List<Integer> list;
            if ( check == 0 )
            {
                String s = input.nextLine();
                String[] sC = s.split(" ");
                k = Integer.parseInt(sC[1]);
            }else{
                list = new ArrayList<>();
                String s = input.nextLine();
                String[] sC = s.split(" ");
                for (String st : sC) list.add(Integer.parseInt(st));
                countDown(c,list,k);
                k = 0;
                check = -1;
                c++;
            }
            check++;
        }
    }
}
