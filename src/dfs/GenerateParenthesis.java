package dfs;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
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
public class GenerateParenthesis {
    static ArrayList<java.lang.String> result = new ArrayList<java.lang.String>();
    static StringBuffer curSb = new StringBuffer();

    public static void main(java.lang.String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        generateParenthesis(n,n);
        System.out.println(result);
    }

    public static void generateParenthesis(int left, int right){
        if(left==0 && right==0) {
            result.add(curSb.toString());
            curSb = new StringBuffer();
            return;
        } else if(left == right) {
            curSb.append("(");
            StringBuffer bak = new StringBuffer(curSb);
            generateParenthesis(left-1,right);
            curSb = bak;
        } else if(left==0) {
            curSb.append(")");
            StringBuffer bak = new StringBuffer(curSb);
            generateParenthesis(left,right-1);
            curSb = bak;
        } else {
            curSb.append("(");
            StringBuffer bak = new StringBuffer(curSb);
            generateParenthesis(left-1,right);
            curSb = bak;
            curSb.setCharAt(curSb.length()-1,')');
            bak = new StringBuffer(curSb);
            generateParenthesis(left, right-1);
            curSb = bak;
        }
    }
}
