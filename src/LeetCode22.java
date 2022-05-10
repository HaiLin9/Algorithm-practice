import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hailin6
 * @version 2022/1/14
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(res, sb, 0, n);
        return res;
    }

    public void generateParenthesis(List<String> res, StringBuilder sb, int left, int n) {
        if(n==0){
            int oriLeft = left;
            while (left>0) {
                sb.append(")");
                left--;
            }
            res.add(sb.toString());
            sb.delete(sb.length() - oriLeft, sb.length());
            return;
        }
        sb.append("(");
        generateParenthesis(res, sb, left+1, n-1);
        sb.delete(sb.length()-1, sb.length());
        if(left>0){
            sb.append(")");
            generateParenthesis(res, sb, left-1, n);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}
