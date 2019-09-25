package leetcode.integer;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.lang.Math;

public class NumDivide {

    public int divide(int dividend, int divisor) {
        int positive = 1;
        positive = ((dividend>0) ^ (divisor>0))? -1 : 1;

        long ms = Math.abs((long)dividend);
        long ns = Math.abs((long)divisor);
        int num = 0;
        while(ms >= ns){
            long n = 1;
            long m = ns;
            while(ms>=(m<<1)){
                m<<=1;
                n<<=1;
            }
            num += n;
            ms -= m;
        }
        return positive * num;
    }
}
