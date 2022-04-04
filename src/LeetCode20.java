import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hailin6
 * @version 2022/1/13
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        if(s ==null || "".equals(s)){
            return true;
        }
        Deque<Character> tmp = new LinkedList<>();
        for(char c:s.toCharArray()){
            if(c=='[' || c=='{' || c == '('){
                tmp.push(c);
            } else {
                if(tmp.isEmpty() || c=='}' && tmp.pop()!='{' || c==']' && tmp.pop()!='[' || c==')' && tmp.pop()!='('){
                    return false;
                }
            }
        }
        if(tmp.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
