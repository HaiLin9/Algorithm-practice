package leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0){
            return 0;
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] arr = new int[m][n];
        if(obstacleGrid[0][0]==0){
            arr[0][0] =1;
        }
        return paths(m,n,arr,obstacleGrid);

    }

    public int paths(int x, int y, int[][] arr,int[][] obstacleGrid){
        if(obstacleGrid[x-1][y-1]==1) {
            return 0;
        }
        if(x==1&&y==1){
            return arr[0][0];
        } else if(x==1&&y>1){
            if(obstacleGrid[x-1][y-2]==1){
                return 0;
            }
            if(arr[x-1][y-1]==0) {
                arr[x - 1][y - 1] = paths(x, y - 1, arr,obstacleGrid);
            }
            return arr[x-1][y-1];
        } else if(y==1&&x>1){
            if(obstacleGrid[x-2][y-1]==1){
                return 0;
            }
            if(arr[x-1][y-1]==0){
                arr[x-1][y-1] = paths(x-1,y,arr,obstacleGrid);
            }
            return arr[x-1][y-1];
        } else{
            if(arr[x-1][y-1]==0) {
                if(obstacleGrid[x-2][y-1]==1 && obstacleGrid[x-1][y-2]==1){
                    return 0;
                } else if(obstacleGrid[x-2][y-1]==1){
                    arr[x - 1][y - 1] = paths(x , y-1, arr,obstacleGrid);
                } else if(obstacleGrid[x-1][y-2]==1){
                    arr[x - 1][y - 1] = paths(x-1 , y, arr,obstacleGrid);
                } else{
                    arr[x - 1][y - 1] = paths(x - 1, y, arr,obstacleGrid) + paths(x, y - 1, arr,obstacleGrid);
                }
            }
            return arr[x-1][y-1];
        }
    }
}
