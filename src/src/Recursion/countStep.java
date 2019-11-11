package Recursion;

public class countStep {

    // Program to find n-th stair
// using step size 1 or 2 or 3.



        // Returns count of ways to reach
        // n-th stair using 1 or 2 or 3 steps.
        public static int findStep(int n)
        {
            if (n == 1 || n == 0)
                return 1;
            else if (n == 2)
                return 2;

            else
                return findStep(n - 3) +
                        findStep(n - 2) +
                        findStep(n - 1);
        }

        public static int findStepIterative(int n){
            int[] step = new  int[n + 1];
            step[0] = 1;
            step[1] = 1;
            for(int i = 2; i < n + 1; i++){
                step[i] = step[i - 1] + step[i - 2];
            }

            return step[n];
        }

        // Driver function
        public static void main(String argc[]){
            int n = 4;
            System.out.println(findStep(n));
            System.out.println(findStepIterative(n));
        }


}
