/**
 * @author hailin6
 * @version 2022/1/11
 * 思路：https://leetcode.cn/problems/reverse-integer/solution/by-lfool-1x23/
 */
public class LeetCode7 {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        int sign = x<0? -1: 1;
        if(sign==-1){
            x = -x;
        }
        int res =0;
        while(x>0){
            int yu = x % 10;
            //由于不能用long类型来判断是否溢出， 只能利用max的逆运算进行
            // res*10 + yu > max  => 溢出
            // res > (max -yu)/ 10
            if(res>(Integer.MAX_VALUE - yu)/10){
                return 0;
            }
            res = res *10 + yu;
            x/=10;
        }
        return sign*res;
    }


    }

