public class LeetCode45 {

    public int jump(int[] nums) {
        int[] dp =new int[nums.length];
        for(int i=1; i<dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j<i; j++){
                if(dp[j]< Integer.MAX_VALUE && j + nums[j]>=i){
                    dp[i] = Math.min(dp[j] +1,dp[i]);
                }
            }
        }
        return dp[nums.length-1];
    }
}
