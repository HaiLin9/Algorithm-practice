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
            int max =0;
            for(int start=0;start<s.length();start++){
                Set<Character> set = new HashSet<>();
                int j=start;
                while(j<s.length() && !set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    j++;
                }
                max = Math.max(max, j-start);
            }
            return max;
        }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }
}
