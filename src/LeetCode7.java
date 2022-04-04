/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode7 {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE){
            return 0;
        }
        int sign =1;
        if(x<0){
            sign =-1;
            x=-x;
        }
        int sum =0;
        while(x>0){
            int num = x%10;
            if(sum > Integer.MAX_VALUE/10){
                return 0;
            }
            sum = sum*10+num;
            x/=10;
        }
        return sign* sum;

    }


    }

