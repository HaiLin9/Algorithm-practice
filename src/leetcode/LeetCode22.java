package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出?n?代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出?n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        generateParenthesis(result, sb, n,n);
        return result;
    }

    public void generateParenthesis(List<String> result, StringBuffer sb, int left, int right) {
        if(left ==0 && right ==0){
            result.add(sb.toString());
        } else if (left ==0 && right>0){
            sb.append(')');
            generateParenthesis(result, sb, left, right-1);
            sb.deleteCharAt(sb.length()-1);
        } else if(left == right){
            sb.append('(');
            generateParenthesis(result, sb, left-1, right);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append('(');
            generateParenthesis(result, sb, left-1, right);
            sb.deleteCharAt(sb.length()-1);
            sb.append(')');
            generateParenthesis(result, sb, left, right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
