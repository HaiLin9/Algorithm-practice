/**
 * @author hailin6
 * @version 2022/1/18
 */
public class LeetCode29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0){
            return dividend;
        }
        if(dividend == Integer.MIN_VALUE){
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }
            if(divisor == 1){
                return Integer.MIN_VALUE;
            }
        }
        int sign =1;
        if((dividend>0&& divisor<0) ||dividend<0&& divisor>0){
            sign = -1;
        }
        if(dividend>0){
            dividend = -dividend;
        }
        if(divisor>0){
            divisor = -divisor;
        }
        int sum = 0;
        while(dividend <= divisor) {
            sum++;
            dividend-=divisor;
        }
        return sign* sum;
    }

    public static void main(String[] args){
        int res = divide(-2147483648, -1);
    }
}
