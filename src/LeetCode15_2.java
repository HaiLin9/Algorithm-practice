import java.util.*;

/**
 * @author hailin6
 * @version 2022/1/12
 */
public class LeetCode15_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length<3) {
            return  res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            int sum = -nums[i];
            Map<Integer,Integer> tmp = new HashMap<>();
            while(start<end && start >i && end < nums.length){
                if(nums[start] + nums[end]==sum){
                    tmp.put(nums[start], nums[end]);
                    start++;
                    end --;
                } else if(nums[start] + nums[end]>sum){
                    end--;
                } else {
                    start++;
                }
            }
            for(Map.Entry<Integer, Integer> t:tmp.entrySet()){
                List<Integer> re = new ArrayList<>();
                re.add(nums[i]);
                re.add(t.getKey());
                re.add(t.getValue());
                res.add(re);
            }
        }
        return res;
    }
}
