package DFS;

public class wordSearch {

    public static boolean DFS(char[][] board, String word, int position, int i, int j){
        if(word.length() == position) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || word.charAt(position) != board[i][j]) return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found = DFS(board, word, position + 1, i + 1, j)
                || DFS(board,word,position + 1, i - 1, j) || DFS(board,word,position + 1,i,j+1)
                || DFS(board,word,position + 1, i, j - 1);

        board[i][j] = temp;
        return found;

    }
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)  && DFS(board,word,0,i,j) ){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[][] board = {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
};

        System.out.println(exist(board, "ABCC"));

}
    }