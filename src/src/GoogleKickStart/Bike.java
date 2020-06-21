package GoogleKickStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bike{

    public static void bike(int c, int n, List<Integer> list)
    {
        if ( n == 0 ) System.out.println("Case  #" + c + ": 0" );
        int count = 0;
        for ( int i = 1; i < list.size() - 1; i++)
        {
            if (list.get(i - 1) < list.get(i) && list.get(i + 1) < list.get(i)) count++;
        }
        System.out.println("Case #" + c + ": " + count);
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int check = 0, c = 1 , n = 0;
        input.nextLine();
        while (input.hasNext()) {

                List<Integer> list;
                if (check == 0 ) n = Integer.parseInt(input.nextLine());
                else {
                    list = new ArrayList<>();
                    String s = input.nextLine();
                    String[] sC = s.split(" ");
                    for (String st : sC) list.add(Integer.parseInt(st));
                    bike(c, n, list);
                    n = 0;
                    check = -1;
                    c++;
                }
                check++;

        }
    }
}