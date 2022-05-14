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
        public static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int max =0;
            int start =0;
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>=start){
                    start = map.get(s.charAt(i)) + 1;
                }
                max = Math.max(i-start+1, max);
                map.put(s.charAt(i), i);
            }
            return max;
        }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }
}
