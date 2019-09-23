package leetcode;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：先来看一种方法，这种方法是基于动态规划Dynamic Programming的，我们维护一个一维的dp数组，这个DP算法需要遍历两遍数组，第一遍遍历dp[i]中存入i位置左边的最大值。
 * 然后开始第二遍遍历数组，第二次遍历时找右边最大值，然后和左边最大值比较取其中的较小值，然后跟当前值A[i]相比，如果大于当前值，则将差值存入结果。
 */
public class LeetCode42 {
    public int trap(int[] height) {
        if(height ==null || height.length<=1){
            return 0;
        }
        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];

        dpLeft[0] = 0;
        for(int i=1;i<height.length;i++){
            if(height[i-1] > dpLeft[i-1]){
                dpLeft[i] = height[i-1];
            } else{
                dpLeft[i] = dpLeft[i-1];
            }
        }

        dpRight[dpRight.length-1] = 0;
        for(int j = dpRight.length-2;j>=0;j--){
            if(height[j+1]>dpRight[j+1]){
                dpRight[j] = height[j+1];
            } else {
                dpRight[j] = dpRight[j+1];
            }
        }

        int result =0;
        for(int i=1;i<height.length-1;i++){
            int big = Math.min(dpLeft[i],dpRight[i]);
            if(big>height[i]){
                result += big-height[i];
            }
        }
        return result;
    }
}
