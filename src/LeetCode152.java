public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        for(int i=1;i< nums.length;i++){
            if(nums[i]>0) {
                dpMax[i] = Math.max(dpMax[i-1]* nums[i], nums[i]);
                dpMin[i] = Math.min(dpMin[i-1]*nums[i], nums[i]);
            } else {
                dpMax[i] = Math.max(dpMin[i-1]* nums[i], nums[i]);
                dpMin[i] = Math.min(dpMax[i-1] * nums[i], nums[i]);
            }
            if(dpMax[i] >max){
                max =dpMax[i];
            }
        }
        return max;
    }
}
