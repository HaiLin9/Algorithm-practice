package leetcode;

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length==0){
            return 0;
        } else if(nums.length==1){
            return nums[0]==val? 0:1;
        } else {
            int i=0,j=0;
            while(j<nums.length){
                if(nums[j]!=val){
                    nums[i] = nums[j];
                    i++;
                    j++;
                } else{
                    j++;
                }
            }
            return i;
        }
    }
}
