package Math;

public class logarithm {

    public static int log(int base, int number, int power){
        if(number <= 2) return power;
        power += log(base,number/base,power);
        return power ;
    }

    public static void main(String[] args){
        System.out.println("power = "+ log(2,100000000,1));
    }
}
