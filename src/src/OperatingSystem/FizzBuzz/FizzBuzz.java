package OperatingSystem.FizzBuzz;

/***
 * FizzBuzz: In the classic problem FizzBuzz, you are told to print the numbers from 1 to n. However, when the number is divisible by 3, print "Fizz''.
 * When it is divisible by 5, print "Buzz''. When it is divisible by 3 and 5, print"FizzBuzz''. In this problem, you are asked to do this in a multithreaded way.
 * Implement a multithreaded version of FizzBuzz with four threads. One thread checks for divisibility of 3 and prints"Fizz''. Another thread is responsible for divisibility of 5 and prints"Buzz''.
 * A third thread is responsible for divisibility of 3 and 5 and prints"FizzBuzz''. A fourth thread does the numbers.
 */
public class FizzBuzz {
    public static void main(String[] args){
        Thread[] thread = {new FizzBuzzThread(true,true,25,"FizzBuzz"),
                new FizzBuzzThread(true,false,25,"Fizz"),
                new FizzBuzzThread(false,true,25,"Buzz"),
                new NumberThread(false,false,25),};

        for(Thread instance: thread ){
            instance.start();
        }
    }
}
