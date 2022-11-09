import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for(int num:nums1){
            int count = m.getOrDefault(num,0);
            m.put(num,count+1);
        }
        for(int num:nums2) {
            int count = m.getOrDefault(num,0);
            if(count>0){
                res.add(num);
                m.put(num,count-1);
            }
        }
        return res.stream().mapToInt((k)->k.intValue()).toArray();

    }
}
