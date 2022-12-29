import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hailin6
 * @version 2022/1/7
 * 暴力解法
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int res = 1;
        int start =0;
        int end=0;
        Map<Character, Integer> map = new HashMap<>();
        while(end<s.length()){
            while(end<s.length() && (!map.containsKey(s.charAt(end)) ||map.containsKey(s.charAt(end)) && map.get(s.charAt(end))<start)){
                map.put(s.charAt(end), end);
                res = Math.max(res, end-start+1);
                end++;
            }
            if(end<s.length()) {
                start = map.get(s.charAt(end)) +1;
            }
        }
        return res;
    }

}
