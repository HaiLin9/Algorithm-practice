public class Huawei {
    public int[] nextGreaterElement(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                dp[i] = nums[i+1];
            } else {
                int j=i+1;
                while(nums[j]<nums[i] && j< nums.length){
                    j++;
                }
                if(j< nums.length){
                    dp[i] = nums[j];
                } else {
                    dp[i] = 0;
                }
            }
        }
        return dp;
    }
}
