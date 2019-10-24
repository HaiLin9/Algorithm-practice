package leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode64 {

    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row][col];
        result[0][0] = grid[0][0];
        for(int i=0; i<row; i++){
            for(int j =0; j<col; j++){
                if(i==0 && j==0){
                    continue;
                }
                if(i==0){
                    result[i][j] = result[i][j-1] + grid[i][j];
                } else if(j == 0){
                    result[i][j] = result[i-1][j] + grid[i][j];
                } else{
                    result[i][j] = Math.min(result[i-1][j],result[i][j-1]) + grid[i][j];
                }
            }
        }

        return result[row-1][col-1];
    }
}
