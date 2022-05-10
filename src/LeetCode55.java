public class LeetCode55 {
    public static boolean canJump(int[] nums) {
        if(nums.length<=1){
            return true;
        }
        boolean[] dp= new boolean[nums.length];
        dp[0] = true;
        for(int i=1;i< nums.length; i++){
            for(int j=0;j<i;j++){
                if(dp[j] && j+nums[j]>=i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(canJump(arr));
    }
}
