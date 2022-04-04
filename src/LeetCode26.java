/**
 * @author hailin6
 * @version 2022/1/17
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length ==1){
            return 1;
        }
        int res=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                nums[++res] = nums[i];
            }
        }
        return res+1;
    }
}
