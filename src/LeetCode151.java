
import java.util.*;

public class LeetCode151 {

    public String reverseWords(String s) {
        int left =0;
        int right = s.length()-1;
        while(left<right && s.charAt(left)==' '){
            left++;
        }
        while(left<right && s.charAt(right)==' '){
            right--;
        }
        Deque<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(left<=right){
            if(s.charAt(left)==' '){
                if(sb.length()>0){
                    queue.offerFirst(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(s.charAt(left));
            }
            left++;
        }
        if(sb.length()>0){
            queue.offerFirst(sb.toString());
        }
        return String.join(" ", queue);
    }

    public String reverseWords2(String s) {
        s = s.trim();
        List<String> sArr= Arrays.asList(s.split("\\s+"));
        Collections.reverse(sArr);
        return String.join(" ", sArr);

    }
}
