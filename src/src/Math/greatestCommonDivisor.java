package Math;

/***
 * greatest common divisor is the max number that are factor of both a and b
 * For example: gcd(6,8) = 2 since 2 is the max number that 6 % 2 == 0 and 8 % 2 == 0
 */
public class greatestCommonDivisor {

    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        return gcd(num2,num1 % num2);
    }

    public static void main(String[] args){
        System.out.println("gcd of 6 and 8 is " + gcd(6,8));
    }
}
