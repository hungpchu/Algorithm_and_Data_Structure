package Array;

import java.util.Random;

public class array_initialization {

   public static void main(String[] args) {
       int[] array = new int[10];

       Random random = new Random();

       for (int i = 0; i < array.length; i++) array[i] = random.nextInt(array.length);


       for (int a : array) System.out.print(a + " ");

   }


}
