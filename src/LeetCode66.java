import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int carry=0;
        for(int i=digits.length-1;i>=0;i--) {
            int num = digits[i] + carry;
            if(i== digits.length-1) {
                num++;
            }
            if(num>=10) {
                carry = 1;
            } else {
                carry = 0;
            }
            res.add(0,num%10);
        }
        if(carry==1) {
            res.add(0,1);
        }
        Integer[] re= res.toArray(new Integer[0]);
        return  Arrays.stream(re).mapToInt(Integer::intValue).toArray();
    }
}
