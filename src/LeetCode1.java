import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin6
 * @version 2022/1/7
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
