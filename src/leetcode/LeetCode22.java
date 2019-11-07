package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����?n?�����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 *
 * ���磬����?n = 3�����ɽ��Ϊ��
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/generate-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
