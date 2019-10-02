package leetcode;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
         int[][] arr = new int[n][n];
         int num = 1;
         for(int startX=0,startY=0,endX=n-1,endY=n-1;startX<=endX&&startY<=endY;startX++,startY++,endX--,endY--){
             num = generateMatrix(arr,startX,startY,endX,endY,num);
         }
         return arr;
    }

    public int generateMatrix(int[][] arr, int startX, int startY, int endX, int endY, int num) {
        if(startX==endX && endY==startY) {
            arr[startX][startY] = num++;
        } else if(startX<endX && startY<endY){
            for(int i=startY; i<endY; i++) {
                arr[startX][i]=num++;
            }
            for(int i=startX;i<endX;i++) {
                arr[i][endY] = num++;
            }
            for(int i= endY; i>startY ;i--) {
                arr[endX][i] = num++;
            }
            for(int i=endX; i>startX; i--) {
                arr[i][startY] = num++;
            }
        }
        return num;
    }
}
