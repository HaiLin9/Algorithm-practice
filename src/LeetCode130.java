public class LeetCode130 {
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0){
            return;
        }
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length; j++){
                if(i==0||i== board.length-1||j==0||j==board[0].length-1){
                    help(board,i,j);
                }
            }
        }
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length; j++){
                if(board[i][j]==' '){
                    board[i][j]='O';
                } else if (board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }

    public void help(char[][] board, int i, int j){
        if(i<0 || i>= board.length ||j<0||j>=board[0].length){
            return;
        }
        if(board[i][j] =='X' ||board[i][j]==' '){
            return;
        }
        board[i][j]=' ';
        help(board, i, j-1);
        help(board, i, j+1);
        help(board, i-1, j);
        help(board, i+1, j);
    }
}
