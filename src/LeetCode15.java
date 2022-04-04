import java.util.*;

/**
 * @author hailin6
 * @version 2022/1/12
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length<3) {
            return  res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int sum = -nums[i];
            Map<Integer, Integer> tmp = new HashMap<>();
            for(int j=i+1;j<nums.length;j++){
                if(tmp.containsKey(nums[j])){
                    if(tmp.get(nums[j])>0){
                        List<Integer> re = new ArrayList<>();
                        re.add(nums[i]);
                        re.add(nums[tmp.get(nums[j])]);
                        re.add(nums[j]);
                        if(nums[i] <= nums[tmp.get(nums[j])] && nums[tmp.get(nums[j])]<= nums[j]){
                            res.add(re);
                            tmp.put(nums[j], -1);
                        }
                    }
                } else {
                    tmp.put(sum-nums[j], j);
                }
            }
        }
        return res;
    }
}
