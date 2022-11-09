import java.util.*;

/**
 * @author hailin6
 * @version 2022/1/12
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            Set<Integer> s = new HashSet<>();
            while(left<right){
                if(nums[left]+nums[right]>target){
                    right--;
                } else if(nums[left]+nums[right]<target){
                    left++;
                } else {
                    if (!s.contains(nums[left])){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        res.add(l);
                        s.add(nums[left]);
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
