/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode7 {
    public int reverse(int x) {
        int sign =1;
        if(x<0){sign = -1;}
        int sum=0;
        while(x!=0){
            int cur = Math.abs(x%10);
            if(sum * 10L + cur> Integer.MAX_VALUE){
                return 0;
            }
            sum = sum *10 + cur;
            x/=10;
        }
        return sign* sum;
    }
}
