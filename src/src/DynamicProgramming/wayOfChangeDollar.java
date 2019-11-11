package DynamicProgramming;

public class wayOfChangeDollar {

    public static int wayOfExchangeDollar(int input){
        int[] way = new int[input + 1];
        // base case: 1 way to exchange 0 cent
        way[0] = 1;
        //if there is only 25 cen first
        int i;
        int cent = 25;
        for(i = cent; i < way.length; i++) way[i] += way[i - cent];
        // if we including more 10 cent -> we have 10, 25
        cent = 10;
        for(i = cent; i < way.length; i++) way[i] += way[i - cent];
        // if we include 5 cent -> we have 5,10,25
        cent = 5;
        for(i = cent; i< way.length; i++) way[i] += way[i - cent];
        // finally include 1 cent
        cent = 1;
        for(i = cent; i < way.length; i++) way[i] += way[i - cent];

        return way[way.length - 1];
    }

    public static void main(String[] args){
        System.out.println("way of exchange 100 dollar = "+ wayOfExchangeDollar(100));
    }
}
