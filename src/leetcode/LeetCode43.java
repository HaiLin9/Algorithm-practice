package leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode43 {
    public static void main(String[] args){
        multiply("123","456");
    }

    public static String multiply(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0){
            return "0";
        }
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();

        long result = 0;
        for(int i=num2Chars.length-1; i>=0; i--) {
            int numI = (int)num2Chars[i] -(int)'0';
            numI = i<num2Chars.length-1 ? (int)(numI*Math.pow(10,num2Chars.length-i-1)):numI;
            for(int j=num1Chars.length-1; j>=0 ; j--) {
                int numJ = (int)num1Chars[j] -(int)'0';
                numJ = j<num1Chars.length-1 ? (int)(numJ*Math.pow(10,num1Chars.length-j-1)):numJ;
                result += numI*numJ;
            }
        }
        return Long.valueOf(result).toString();
    }
}
