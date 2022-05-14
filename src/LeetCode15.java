import java.util.*;

/**
 * @author hailin6
 * @version 2022/1/12
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                if(start>i+1 && nums[start] == nums[start-1]){
                    start++;
                    continue;
                }
                if(nums[start] + nums[end]<target){
                    start++;
                } else if(nums[start] + nums[end]>target){
                    end--;
                } else {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[start]);
                    r.add(nums[end]);
                    res.add(r);
                    start++;
                    end--;
                }
            }
        }
        return res;
    }
}
