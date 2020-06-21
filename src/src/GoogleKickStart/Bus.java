package GoogleKickStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bus {


    public static void bus(int c, long day,  List<Long> list)
    {
        if ( day == 0 ) System.out.println("Case  #" + c + ": 0" );
        long  diff = day / list.get(list.size() - 1);
        for ( int i = list.size() - 1; i >= 1 ; i--)
        {
           list.set(i, list.get(i) * diff);
           diff = list.get(i)/list.get(i - 1);
        }
        list.set(0,list.get(0) * diff);
        System.out.println("Case #" + c + ": " + list.get(0));
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int check = 0, c = 1;
        long day = 0L;
        input.nextLine();
        while (input.hasNext()) {

            List<Long> list;
            if (check == 0 ){
                String[] line = input.nextLine().split(" ");
                for ( int i = 0; i < line[1].length(); i++) day = day*10 + (line[1].charAt(i) - '0');
            }
            else {
                list = new ArrayList<>();
                String s = input.nextLine();
                String[] sC = s.split(" ");
                for (String st : sC) list.add(Long.parseLong(st));
                bus(c, day, list);
                day = 0;
                check = -1;
                c++;
            }
            check++;
        }
    }
}

//3
//4 1000000000000
//11 10 5 50