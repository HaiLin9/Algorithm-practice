public class LeetCode152 {
    public int maxProduct(int[] nums) {
        if(nums.length==1){
            return  nums[0];
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int res = nums[0];
        dpMax[0] = dpMin[0] = nums[0];
        for(int i=1;i< nums.length;i++){
            if(nums[i]<0){
                dpMax[i] = Math.max(nums[i], dpMin[i-1]*nums[i]);
                dpMin[i] = Math.min(nums[i], dpMax[i-1]*nums[i]);
            } else {
                dpMax[i] = Math.max(nums[i], dpMax[i-1]*nums[i]);
                dpMin[i] = Math.min(nums[i], dpMin[i-1]*nums[i]);
            }
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }
}
