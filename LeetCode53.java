
public class LeetCode53 {

    /**
     * ±©Á¦½â·¨
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int res = nums[0];
        for(int i=0;i< nums.length; i++){
            int sum=0;
            for(int j=i;j< nums.length;j++){
                sum+=nums[j];
                res = M
            }
        }
    }
}
