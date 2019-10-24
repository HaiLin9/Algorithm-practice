package leetcode;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = dpMax[0] = nums[0];
        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            dpMin[i] = Math.min(Math.min(dpMin[i-1] * nums[i], dpMax[i-1]*nums[i]), nums[i]);
            dpMax[i] = Math.max(Math.max(dpMin[i-1] * nums[i], dpMax[i-1]*nums[i]), nums[i]);
            if(dpMax[i]>max){
                max= dpMax[i];
            }
        }
        return max;
    }
}
