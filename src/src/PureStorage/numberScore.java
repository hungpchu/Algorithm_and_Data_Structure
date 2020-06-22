package PureStorage;

public class numberScore {

    public static int get124(int num)
    {
        int  point = 0;
        if ( num % 3 == 0 ) point += 2;
        while ( num > 0 )
        {
            int last = num % 10;
            if ( last % 2 == 0 ) point += 4;
            if ( last == 7 ) point++;
            num /= 10;
        }
        return point;
    }

    public static int getN ( int num )
    {
        int point = 0;
        String n = String.valueOf(num);
        int i = 0;
        while ( i < n.length()  )
        {
            int count = 1;
            while ( i + 1 < n.length() &&  (n.charAt(i) - '0' ) - 1 ==  (n.charAt(i + 1) - '0' ) )
            {
                count++;
                i++;
            }
            point += count*count;
            i++;
        }
        return point;
    }

    public static int get5 ( int num )
    {
        int point = 0;
        while ( num > 0 )
        {
            int last = num % 10, length = 0;
            while ( num > 0 && last == 5 )
            {
                num /= 10;
                last = num % 10;
                length++;
            }
            if ( length > 1) point += 3 + 3*(length - 2);
            num /= 10;
        }
        return point;
    }

    public static int getScore(int num){ return  get5(num) + getN(num) + get124(num); }


    public static void main(String[] args)
    {
        int num = 432197850;
        System.out.println( "result = "+ getScore(num) );
    }
}
