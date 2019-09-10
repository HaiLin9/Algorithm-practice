package leetcode.string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class IsValidBracket {

    public static void main(String[] args){
        System.out.println(isValid("()[]{}"));
    }
    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        ArrayList<Character> stack = new ArrayList<>() ;
        for(int i=0;i<s.length();i++){
            System.out.println(stack+""+s.charAt(i));
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(') {
                stack.add(s.charAt(i));
            } else if( s.charAt(i)=='}' || s.charAt(i)==']' || s.charAt(i)==')'){
                if(stack.size()>0 && stack.get(stack.size()-1)==map.get(s.charAt(i))){
                    stack.remove(stack.size()-1);
                } else{
                    return false;
                }
            }
        }
        if(stack.size()>0){
            return false;
        } else {
            return true;
        }
    }
}
