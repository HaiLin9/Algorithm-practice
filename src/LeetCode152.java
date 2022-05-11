public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] dpMax =new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for(int i=1;i< nums.length;i++){
            if(nums[i]<0){
                dpMin[i] = Math.min(dpMax[i-1]*nums[i], nums[i]);
                dpMax[i] = Math.max(dpMin[i-1]*nums[i], nums[i]);
            } else {
                dpMin[i] = Math.min(dpMin[i-1]*nums[i], nums[i]);
                dpMax[i] = Math.max(dpMax[i-1]*nums[i], nums[i]);
            }
            max = Math.max(dpMax[i], max);
        }
        return max;
    }
}
