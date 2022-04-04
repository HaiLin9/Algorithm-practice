/**
 * @author hailin6
 * @version 2022/1/17
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int first =0;
        int second = 0;
        for(;second<nums.length;second++){
            if(nums[second] != val){
                nums[first++] = nums[second];
            }
        }
        return first;
    }
}
