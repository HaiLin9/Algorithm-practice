package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix==null || matrix.length==0){
            return result;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        for(int startX = 0, startY =0, endX=n-1, endY = m-1; startX<=endX && startY<=endY ;startX++,startY++,endX--,endY--) {
            fillListFromCircle(matrix,result,startX,startY,endX,endY);
        }
        return result;
    }

    private void fillListFromCircle(int[][] matrix, List<Integer> result, int startX, int startY, int endX, int endY){
            //一行
        if(startX==endX){
            for(int j=startY;j<=endY;j++){
                result.add(matrix[startX][j]);
            }
            //一列
        } else if(startY==endY){
            for(int i=startX; i<=endX; i++){
                result.add(matrix[i][startY]);
            }
            //一圈
        } else {
            for(int j=startY;j<endY;j++){
                result.add(matrix[startX][j]);
            }
            for(int i=startX;i<endX;i++){
                result.add(matrix[i][endY]);
            }
            for(int j=endY; j>startY; j--){
                result.add(matrix[endX][j]);
            }
            for(int i=endX;i>startX;i--){
                result.add(matrix[i][startY]);
            }
        }
    }
}
