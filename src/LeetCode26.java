/**
 * @author hailin6
 * @version 2022/1/17
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int next =0;
        for(int i=1; i< nums.length ;i++){
            if(nums[i]==nums[next]){
                continue;
            } else {
                nums[++next] = nums[i];
            }
        }
        return next+1;
    }
}
