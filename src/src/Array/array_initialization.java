package Array;

import java.util.Random;

public class array_initialization {

   public static void main(String[] args) {
       int[] array = new int[10];
       int[] randomArr = {1,2,3,4,5,6};

       Random random = new Random();

       for (int i = 0; i < array.length; i++) array[i] = random.nextInt(array.length);

       for(int i = 0; i < randomArr.length;i++){
           int randomIndex = random.nextInt(randomArr.length - 1);
           int temp = randomArr[i];
           randomArr[i] = randomArr[randomIndex];
           randomArr[randomIndex] = temp;
       }

        for(int n: randomArr) System.out.print(n + " ");
//       for (int a : array) System.out.print(a + " ");

   }


}
