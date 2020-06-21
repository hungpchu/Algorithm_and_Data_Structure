package PureStorage;

public class numberScore {

    public static int get124(int num)
    {
        int sum = 0, point = 0;
        while ( num != 0 )
        {
            int last = num % 10;
            if ( last % 2 == 0 ) point += 4;
            if ( last == 7 ) point++;
            sum += last;
            num /= 10;
        }
        return point;
    }

    public static int getN ( int num )
    {
        int point = 0;
        while ( num != 0 )
        {
            int last = num % 10, count = 1;
            while ( num != 0 && last == ( (num/10) % 10) - 1 )
            {
                count++;
                num /= 10;
                last = num % 10;
            }
            point += count*count;
            num /= 10;
        }
        return point;
    }

    public static int get5 ( int num )
    {
        int point = 0;
        while ( num != 0 )
        {
            int last = num % 10, length = 0;
            while ( num != 0 && last == 5 )
            {
                num /= 10;
                last = num % 10;
                length++;
            }
            if ( length > 1) point += 3*(length - 1) + 3*(length - 2);
        }
        return point;
    }

    public static int getScore(int num){ return get124(num) + get5(num) + getN(num); }

    public static void main(String[] args)
    {
        int num = 5555;
       System.out.println( "result = "+ getScore(num) );
    }
}
