package leetcode;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode130 {

    public void solve(char[][] board) {
        int row = board.length;
        if(row <= 1){
            return;
        }
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int c=0; c<col ; c++){
            if(board[0][c]=='O'){
                dfs(0, c, board, visited);
            }
            if(board[row-1][c]=='O'){
                dfs(row-1, c, board, visited);
            }
        }

        for(int r=0; r<row ; r++){
            if(board[r][0]=='O') {
                dfs(r, 0, board, visited);
            }
            if(board[r][col-1]=='O'){
                dfs(r, col-1, board, visited);
            }
        }

        for(int i=0; i<row ;i++){
            for(int j=0; j<col ;j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board, boolean[][] visited) {
        if(row<0 || col<0 || row==board.length || col==board[0].length){
            return;
        }
        if(visited[row][col]){
            return;
        }
        if(board[row][col]=='O') {
            visited[row][col] = true;
            dfs(row-1, col, board, visited);
            dfs(row+1, col, board, visited);
            dfs(row,col-1, board, visited);
            dfs(row,col+1, board, visited);
        }
    }
}
