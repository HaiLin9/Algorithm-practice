package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1 && nums[i]<=0; i++){
            int j = i+1, k = nums.length-1;
            //ШЅжи
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while(j<k){
                if(nums[i]+ nums[j] + nums[k] == 0){
                    if(j+1<k-1 && nums[j]==nums[j+1] && nums[k]==nums[k-1]){
                        j++;
                        k--;
                        continue;
                    }
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                } else if(nums[i]+ nums[j] + nums[k] < 0 ){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return result;
    }
}
