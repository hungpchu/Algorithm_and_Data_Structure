package combinationSearch.Backtracking;


public class sudokuSolver {




    public static void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
            solveHung(board);
    }

    public static boolean solveHung(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] == '.'){
                    for(char num = '1'; num <= '9' ; num++){
                        if(fillValid(board,i,j,num)) board[i][j] = num;
                        else{
                            board[i][j] = '.';
                            continue;
                        }
                        if(!solveHung(board)) board[i][j] = '.';
                        else return true;
                    }
                    if(board[i][j] == '.') return false;
                }

            }
        }
        return true;
    }

    /***
     * Time : O(9^m) with m is the number of '.'
     * @param board
     * @return
     */
    public static boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                // if there is '.'
                if(board[i][j] == '.'){
                    // range of char to fill in
                    for(char num = '1'; num <= '9';num++){

//                         if fill valid the fill the number inside
                        if(fillValid(board,i,j,num)) {
                            board[i][j] = num;

                            // fill next '.' -> if the next '.' is valid then return true
                            if (solve(board)) return true;
                            // else restore the '.'
                            else board[i][j] = '.';
                        }


                        // fill continuously for the next '.'

                    }
                    // at the end of the value is still '.' then return false
                    if(board[i][j] =='.') return false;
                }
            }
        }
        // if fill success til the end then return true
        return true;
    }

    public static boolean fillValid(char[][] board, int row, int col, char num){
        for(int i =0; i < 9;i++){
            // check row
            if(board[row][i] != '.' && board[row][i] == num) return false;
            if(board[i][col] != '.' && board[i][col] == num) return false;
            int rowGrid3 = 3*(row/3) + i/3;
            int colGrid3 = 3*(col/3) + i % 3;
            if(board[rowGrid3][colGrid3] != '.' && board[rowGrid3][colGrid3] == num) return false;
         }
        return true;
    }

    public static void showBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(char c: board[i]) System.out.print(c+" ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                         ,{'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);

        showBoard(board);

    }
}
