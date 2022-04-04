/**
 * @author hailin6
 * @version 2022/1/18
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length <=1){
            return;
        }
        int start = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                if(i>start){
                    start=i;
                }
            }
        }
        if(start>-1){
            int tmp= nums[start+1];
            nums[start+1] = nums[start];
            nums[start] = tmp;
        } else {
            int i=0, j= nums.length-1;
            while(i<j){
                int tmp= nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
