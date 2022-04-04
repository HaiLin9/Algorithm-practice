import java.util.*;

/**
 * @author hailin6
 * @version 2022/1/13
 */
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums ==null || nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int sum = target - nums[i] - nums[j];
                Map<Integer, Integer> re = new HashMap<>();
                int start = j+1;
                int end = nums.length-1;
                while(start < end && end<nums.length && start > j){
                    if(nums[start] + nums[end] == sum){
                        re.put(nums[start],nums[end] );
                        start++;
                        end--;
                    } else if(nums[start] + nums[end] < sum){
                        start++;
                    } else {
                        end--;
                    }
                }
                for(Map.Entry<Integer, Integer> entry:re.entrySet()){
                    List<Integer> one = new ArrayList<>();
                    one.add(nums[i]);
                    one.add(nums[j]);
                    one.add(entry.getKey());
                    one.add(entry.getValue());
                    res.add(one);
                }
            }
        }
        return res;
    }
}
