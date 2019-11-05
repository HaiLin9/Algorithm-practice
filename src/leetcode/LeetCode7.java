package leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例?1:
 *
 * 输入: 123
 * 输出: 321
 * ?示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode7 {
    public int reverse(int x) {
        int result=0;
        int positive = 1;
        if(x<0){
            positive = -1;
            x = -x;
        }
        while(x>0){
            int val = x % 10;
            x/=10;
            result = result*10 + val;
        }
        if(result>=Integer.MAX_VALUE||result<=Integer.MIN_VALUE){
            return 0;
        }
        return result * positive;
    }
}
