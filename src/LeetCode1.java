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
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(m.containsKey(target-nums[i])){
                return new int[]{m.get(target-nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[0];
    }
}
