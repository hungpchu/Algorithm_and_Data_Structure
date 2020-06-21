package GoogleKickStart.roundC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class perfectSquare {

    public static void perfectSQ(int c, List<Integer> l )
    {
        int[] sum = new int[l.size() + 1];
        int count = 0, j = 1;
        for ( int i = 0; i < l.size(); i++ ) if (l.get(i) >= 0 && Math.sqrt(l.get(i)) % 1 == 0 ) count++;
        sum[1] = l.get(0);
        for (int i = 2; i < l.size() + 1;i++)
        {
            sum[i] += sum[i-1] + l.get(j);
            j++;
        }

        for(int i = 0; i < l.size() + 1; i++)
        {
            for ( j = i+2; j < l.size() + 1; j++)
            {
                if(sum[j] - sum[i] >= 0 && Math.sqrt(sum[j] - sum[i]) % 1 == 0) {
                    count++;
                }
            }
        }

        System.out.println("Case #"+ c + ": " + count );
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int c = 1,check = 1;
        input.nextLine();
        input.nextLine();
        while (input.hasNext()) {
            if (check % 2 != 0)
            {
                List<Integer> list = new ArrayList<>();
                String s = input.nextLine();
                String[] sC = s.split(" ");
                for (String st : sC) list.add(Integer.parseInt(st));
                perfectSQ(c,list);
                c++;
            }else input.nextLine();
            check++;
        }
    }
}
