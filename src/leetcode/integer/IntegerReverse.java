package leetcode.integer;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 */
public class IntegerReverse {
    public static void main(String[] args){
        System.out.println(integerReverse(120));
    }

    public static int integerReverse(int num){
        boolean positive = true;
        if(num<0){
            positive = false;
            num = -num;
        }

        int sum =0;
        while(num>0){
            sum *= 10;
            sum += num%10;
            num /= 10;
        }
        return positive?sum:-sum;
    }
}
