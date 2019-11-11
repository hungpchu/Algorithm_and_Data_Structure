package Math;

import java.util.ArrayList;
import java.util.List;

/***
 * Every positive number can be decomposed into the product of prime
 * prime <= Math.sqrt(n) since every composite number has at least 1 prime factor
 * that less than or equal to square root of itself
 * Math.sqrt(a) = a^(1/2) -> Math.sqrt(9) = 3
 */
public class prime {
    public static boolean isPrime(int n){
        if(n == 1 || n == 0) return true;
        int i = 2;
        while(i <= Math.sqrt(n)){
            if(n % i == 0) return false;
            i++;
        }
        return true;
    }

    /***
     * Top down approach
     * Time:O(N)
     */
    public static List<Integer> primeFactor(int n){
        // check with number 2 as 1st prime
        List<Integer> list = new ArrayList<>();
        if(n == 0|| n == 1){
            list.add(n);
            return list;
        }
        // if the number can divide 2 then take 2 as prime factor
        while (n % 2 == 0){
            n = n / 2;
            list.add(2);
        }
        // get to the 2nd prime number is 3 and remaining prime numbers are odd
        // -> we increase prime by 2
        for(int prime = 3; prime <= Math.sqrt(n); prime += 2){
            // if the number can divide prime then take prime as factor
            while(n % prime == 0){
                n = n/ prime;
                list.add(prime);
            }
        }

        // take care of prime number
        if(n > 2) list.add(n);
        return list;
    }

    public static void primeSequence(int max){
        boolean[] checkPrime = new boolean[max +1];
        for(int prime = 2; prime <= Math.sqrt(max);prime++){
            // if the value of checkPrime is not true
            // then make it true with all of its multiple
            if(!checkPrime[prime]){
                // make true to all the multiple
                for(int multiple = prime * prime; multiple <= max; multiple+= prime) checkPrime[multiple] = true;
            }
        }
        System.out.println("List of prime number up until " + max + " is ");
        // if the checkPrime is false then we have the prime number
        // else if true then it is not prime since it is the multiple of a number
        for(int prime = 2; prime <= max; prime++) if(!checkPrime[prime])System.out.print(prime + " ");
    }

    public static void main(String[] args){
        int number = 23;
        System.out.println("Is this number a prime? " + isPrime(number));
        System.out.print("List of prime factor: ");
        for(int prime: primeFactor(number)) System.out.print(prime + " ");
        primeSequence(30);
    }
}
