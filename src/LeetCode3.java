import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hailin6
 * @version 2022/1/7
 */
public class LeetCode3 {
        public static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> temp = new HashMap<>();
            int left =0;
            int max =0;
            for(int i=0; i<s.length(); i++) {
                if(temp.containsKey(s.charAt(i)) && temp.get(s.charAt(i)) >=left){
                    left = temp.get(s.charAt(i)) +1;
                }
                max = Math.max(max, i-left +1);
                temp.put(s.charAt(i), i);
            }
            return max;
        }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }
}
