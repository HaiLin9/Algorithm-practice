package leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode55_2 {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0) {
            return true;
        }
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(reach[j] && j+nums[j]>=i){
                    reach[i]=true;
                    break;
                }
            }
        }
        return reach[nums.length-1];
    }
}
