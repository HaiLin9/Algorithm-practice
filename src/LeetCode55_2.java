public class LeetCode55_2 {
    // 贪心算法
    public boolean canJump(int[] nums) {
        int max =0;
        for(int i=0;i<nums.length; i++){
            if(max>=i){
                max = Math.max(i+nums[i], max);
                if(max >= nums.length-1){
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
