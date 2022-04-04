import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hailin6
 * @version 2022/1/14
 */
public class LeetCode22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, 0, "", n);
        return res;
    }

    public static void generateParenthesis(List<String> res,int leftBrace, String cur, int n){
        if(n==0) {
            StringBuilder sb = new StringBuilder();
            while(leftBrace>0){
               sb.append(")");
               leftBrace--;
            }
            cur += sb.toString();
            res.add(cur);
        } else {
            if(leftBrace>0){
                generateParenthesis(res, leftBrace-1, cur + ")", n);
            }
            generateParenthesis(res, leftBrace+1, cur+"(", n-1);
        }
    }

    public static void main(String[] args){
        List<String> res =generateParenthesis(3);
    }
}
