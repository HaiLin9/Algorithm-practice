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
        help(res, new StringBuilder(), 0, n);
        return res;
    }

    public void help(List<String> res, StringBuilder cur, int left, int n){
        if(cur.length()==2*n){
            res.add(cur.toString());
            return;
        }
        if(left>0){
            cur.append(")");
            help(res, cur, left-1, n);
            cur.delete(cur.length()-1,cur.length());
        }
        if(cur.length()+left<2*n){
            cur.append("(");
            help(res, cur, left+1, n);
            cur.delete(cur.length()-1,cur.length());
        }
    }


}
