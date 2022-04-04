import java.util.HashMap;
import java.util.Map;

public class Offer39 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max=1;
        int res = nums[0];
        for(int i:nums){
            if(map.containsKey(i)){
               int count =  map.get(i);
               map.put(i,++count);
               if(count > nums.length/2 && count>max){
                   max = count;
                   res = i;
               }
            } else{
                map.put(i,1);
            }
        }
        return res;
    }
}
