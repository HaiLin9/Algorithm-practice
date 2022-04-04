import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin6
 * @version 2022/1/7
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null ||nums.length<=1){
            return new int[0];
        }
        int[] result = new int[2];
        Map<Integer, Integer> mIndex = new HashMap<>();
        for(int i =0; i<nums.length ;i++) {
            if(mIndex.containsKey(nums[i])){
                result[0] = mIndex.get(nums[i]);
                result[1] = i;
                return result;
            }
            mIndex.put(target-nums[i], i); //放到后面
        }
        return result;
    }
}
