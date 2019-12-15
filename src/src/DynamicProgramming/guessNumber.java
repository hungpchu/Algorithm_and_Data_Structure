package DynamicProgramming;

public class guessNumber {
    public static  int getMoneyAmount(int n) {
                 if (n == 1) return 0;
                 int[][] dp = new int[n+1][n+1];

                 for (int len=1; len<=n-1; len++) {
                         for (int i=1; i+len<=n; i++) {
                          int j = i + len;
                            dp[i][j] = Integer.MAX_VALUE;
                              for (int k=i; k<=j; k++) {
                                 dp[i][j] = Math.min(dp[i][j],
                                                            k+Math.max(k==i? 0 : dp[i][k-1],
                                                                           k==j? 0 : dp[k+1][j]));
                                  }
                            }
                     }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
            return dp[1][n];
            }

            public static void main(String[] args){
        System.out.println(getMoneyAmount(3));
//        int[] arr = new int[50000];
//        for(int i = 0; i < 50000;i++){
//            System.out.println(i);
//        }

            }
}
