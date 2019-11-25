package Array;

public class validTicTacToe {

    public static  boolean validTicTacToe(String[] board) {
        int countX =0, countO = 0, win =0, countW = 0;
        boolean winX = false;
        boolean winO = false;

        for(int i = 0; i < board.length; i++){
            String boardString = board[i];
            for(int j = 0; j < boardString.length(); j++ ){
                if(boardString.charAt(j) != ' '){

                    if(boardString.charAt(j) == 'O') countO++;
                    if(boardString.charAt(j) == 'X') countX++;
                    // check win for the 1st time
                    if (win == 0) win = checkWin(board,i,j,boardString.charAt(j));
                    // check which win X or O
                    if(win == 1 && (!winX && !winO)){
                        if(boardString.charAt(j) == 'X') winX = true;
                        else winO = true;
                    }

                }
            }
        }

        //
        if(countX != countO && countO != countX - 1) return false;
        if(winX && countO != countX - 1) return false;

        if(winO && countO != countX ) return false;

        return true;
    }

    public static int checkWin(String[] board,int row, int col, char num ){
        int winRow = 0, winCol = 0, winRDiag = 0, winLDiag = 0, totalWin = 0;

        for(int i = 0 ;i < 3;i++){
            if(board[row].charAt(i) == num) winRow++;
            if(board[i].charAt(col) == num) winCol++;
        }
        // check right diag
        int j = board[row].length() - 1, i = row;
        while(i >= 0 && j >= 0){
            if(board[i].charAt(j) == num) winRDiag++;
            i--;
            j--;
        }

        // check left diag
        j = board[row].length() - 1;
        i = row;
        while(i < board.length && j >= 0){
            if(board[i].charAt(j) == num) winLDiag++;
            i++;
            j--;
        }

        if(winRow == 3) totalWin++;
        if(winCol == 3) totalWin++;
        if(winRDiag == 3) totalWin++;
        if(winLDiag == 3) totalWin++;
        return totalWin;
    }

    public static void main(String[] args){

    }
}
