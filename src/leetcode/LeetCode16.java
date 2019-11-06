package leetcode;

import java.util.Arrays;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length < 3){
            return 0;
        }
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1, k=nums.length-1;
            while (j<k){
                if(nums[i]+nums[j]+nums[k]-target==0) {
                    return target;
                } else if(nums[i]+nums[j]+nums[k]-target<0) {
                    if(Math.abs(nums[i]+nums[j]+nums[k]-target)<Math.abs(result-target)) {
                        result = nums[i]+nums[j]+nums[k];
                    }
                    j++;
                } else{
                    if(Math.abs(nums[i]+nums[j]+nums[k]-target)<Math.abs(result-target)) {
                        result = nums[i]+nums[j]+nums[k];
                    }
                    k--;
                }
            }
        }
        return result;
    }
}
