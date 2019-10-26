package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为?11（即，2?+?3?+?5?+?1?= 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n)?的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        if(dp.length==0){
            return 0;
        }
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++){
            for(int j =0; j<=i; j++){
                if(j>0&&j<i){
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                } else if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
            }
        }
        Arrays.sort(dp[dp.length-1]);
        return dp[dp.length-1][0];
    }
}
