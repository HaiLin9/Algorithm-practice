public class LeetCode45 {

    public int jump(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i=1;i< nums.length; i++){
            for(int j=0;j<i;j++){
                if(j+nums[j]>=i){
                    dp[i] = Math.min(dp[j]+1, dp[i]);
                }
            }
        }
        return dp[nums.length-1];
    }
}
