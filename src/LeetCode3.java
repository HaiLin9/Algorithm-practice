import java.util.HashSet;
import java.util.Set;

/**
 * @author hailin6
 * @version 2022/1/7
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int start=0,end=0;
        int result=0;
        Set<Character> set = new HashSet<>();
        for(;start<s.length();start++){
            if(start-1 >= 0) {
                set.remove(s.charAt(start-1));
            }
            while(end<s.length() && !set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
            }
            if((end-start)>result){
                result = end-start;
            }
        }
        return  result;
    }
}
