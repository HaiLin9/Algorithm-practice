
import java.util.*;

public class LeetCode151 {

    public String reverseWords(String s) {
        int left =0;
        int right = s.length()-1;
        while(s.charAt(left) ==' '){
            left++;
        }
        while(s.charAt(right) ==' '){
            right--;
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(left<=right){
            if(s.charAt(left) == ' '){
                if(sb.length()>0){
                    res.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(s.charAt(left));
            }
            left++;
        }
        if(sb.length()>0){
            res.add(sb.toString());
        }
        Collections.reverse(res);
        return String.join(" ", res);
    }
}
