import java.util.Arrays;

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int[] dp = new int[nums.length + 1];
        int res = Integer.MAX_VALUE;
        for(int i=1;i<= nums.length;i++) {
            dp[i]= nums[i-1] + dp[i-1];
        }
        for(int i=0;i< nums.length;i++){
            int s = dp[i] +target;
            int index = Arrays.binarySearch(dp, s);
            if(index <0){
                index = -(index +1);
            }
            if(index<= nums.length){
                res = Math.min(res, index -i);
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
}
