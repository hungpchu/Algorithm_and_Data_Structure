//package DynamicProgramming;
//
//public class twitter {
//
//
//        /*
//         * Complete the 'maximumTotalWeight' function below.
//         *
//         * The function is expected to return an INTEGER.
//         * The function accepts following parameters:
//         *  1. INTEGER_ARRAY weights
//         *  2. INTEGER_ARRAY tasks
//         *  3. INTEGER p
//         */
//
//        public static int max;
//
//        public static void traverse ( List<Integer> weight, List<Integer> task, int p, int currWe, int currLe, int i)
//        {
//            if ( currLe > p) return;
//            max = Math.max ( max, currWe);
//            for ( int in = i; in < task.size(); in++ )
//            {
//                traverse(weight, task, p, currWe + weight.get(in), currLe + task.get(in), in + 1);
//            }
//        }
//
//        public static int maximumTotalWeight(List<Integer> weights, List<Integer> tasks, int p) {
//            max = 0;
//
//            for ( int i = 0; i < tasks.size(); i++ ) tasks.set(i,tasks.get(i) * 2);
//
//            // Write your code here
//
//            /** recursion (brute force)
//             * time: O(2^N)
//             for ( int i = 0; i < tasks.size(); i++ )
//             {
//             tasks.set(i,tasks.get(i) * 2);
//             }
//
//             traverse(weights, tasks, p, 0, 0, 0);
//
//             return max;
//             */
//
//            // dynamic programming -> knap sack style
//            // time: O(n^2)
//            // space: O(n^2)
//            // table to calculate the max weight needed
//            int[][] table = new int[weights.size()][p + 1];
//
//            // loop through all elements in weight
//            for ( int i = 1; i < weights.size(); i++)
//            {
//                // loop through time from 1 to the max time
//                for ( int j = 1; j <= p; j++ )
//                {
//                    // if the time is smaller than the current time of current weight then
//                    // take the max between the previous time and previous weight
//                    if ( j < tasks.get(i)) table[i][j] = Math.max(table[i - 1][j], table[i][j-1]);
//                        // else if the current time is bigger
//                    else{
//                        // then add the current weight inside to check for the max one
//                        int newWeight = weights.get(i) + table[i - 1][j - tasks.get(i)];
//                        int max = Math.max(newWeight, table[i - 1][j]);
//                        max = Math.max(max, table[i][j  - 1]);
//                        table[i][j] = max;
//                    }
//                }
//            }
//
//            return table[weights.size() - 1][p];
//
//        }
//
//    }
//
//}
