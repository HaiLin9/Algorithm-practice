public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int res = nums[0];
        for(int i=0;i< nums.length; i++){
            int sum=0;
            for(int j=i;j< nums.length;j++){
                sum+=nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public int maxSubArrayV2(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        int dp = nums[0];
        int max = nums[0];
        for(int i=1; i< nums.length ;i++){
            dp = Math.max(nums[i], dp+nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }
}
