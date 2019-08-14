package leetcode.string;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 */
public class AToI {
    public static void main(String[] args){
        System.out.println(aToI("    -42"));
    }

    public static int aToI(String s){
        if(s == null || s.length() ==0){
            return 0;
        }

        int startIndex = 0;
        while(s.charAt(startIndex) != '-' && !Character.isDigit(s.charAt(startIndex))){
            startIndex++;
        }
        s = s.substring(startIndex);

        if(s.length()==0){
            return 0;
        }

        boolean positive = true;
        if(s.charAt(0)=='-') {
            positive = false;
            s=s.substring(1);
        }

        int result=0;
        for(char c:s.toCharArray()){
            if(!Character.isDigit(c)){
                break;
            }
            result *= 10;
            result += Integer.parseInt(Character.toString(c));
        }
        if(!positive){
            result = -result;
        }
        return result;
    }
}
