package Math;

/***
 * Lowest common multiple is the min number that can divide both a and b
 * For example: lcm(6,8) = 24 since 24 is the min number that can divide both 6 and 8
 * Formula: lcm(a,b) = a*b/gcd(a,b)
 * -> ab = gcd(a,b) * lcm(a,b)
 */
public class leastCommonMultiple extends greatestCommonDivisor{
    public static int leastCommonMultiple(int num1,int num2){
        return (num1*num2)/gcd(num1,num2);
    }
    public static void main(String[] args){
        System.out.println(" The lowest common multiple is "+ leastCommonMultiple(6,8));
    }
}
