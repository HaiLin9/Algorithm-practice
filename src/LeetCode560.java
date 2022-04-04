import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    public static int subarraySum(int[] nums, int k) {
       int res =0;
       Map<Integer,Integer> temp = new HashMap<>();
       temp.put(0,1);
       int sum =0;
       for(int i=0;i<nums.length;i++){
           sum +=nums[i];
           if(temp.containsKey(sum-k)){
               res += temp.get(sum-k);
           }
           temp.put(sum, temp.getOrDefault(sum,0)+1);
       }
       return res;
    }

    public static void main(String[] args){
        int[] test ={-1,-1,1};
        int i= subarraySum(test, 0);
    }
}
