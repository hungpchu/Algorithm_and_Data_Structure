package DynamicProgramming;

public class minimumPathSum {

    public static int minimumSum(int[][] board){
        int[][] pathSum = new int[board.length][board[0].length];
        pathSum[0][0] = board[0][0];
        for(int i = 1; i < board.length;i++){
            pathSum[i ][0] = pathSum[i - 1][0] + board[i][0];
        }

        for(int j = 1; j < board[0].length;j++ ) pathSum[0][j] = pathSum[0][j-1] + board[0][j];

        for(int i = 1; i < board.length;i++){
            for(int j = 1; j < board[0].length; j++){
                pathSum[i][j] = board[i][j] + Math.min(pathSum[i-1][j] ,pathSum[i][j-1]);
            }
        }

        for(int j = 0; j < board[0].length;j++ ) {

        for(int i = 0; i < board.length;i++) {
            System.out.print(pathSum[i][j] + " ");

        }
        System.out.println();
        }

        return pathSum[board.length - 1][board[0].length - 1];
    }

    public static void main(String[] args){
        int[][] board = {
                {1,3,1}, {1,5,1},{4,2,1}
        };
        System.out.println(minimumSum(board));
    }
}
