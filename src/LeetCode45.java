public class LeetCode45 {

    public int jump(int[] nums) {
       if(nums.length<=1){
           return 0;
       }
       int[] dp = new int[nums.length];
       for(int i=1; i<nums.length;i++){
           dp[i]= Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(j+nums[j]>=i){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
       }
       return dp[nums.length-1];

    }
}
