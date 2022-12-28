import java.util.ArrayList;
import java.util.List;

public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int num =0;
        for(int n :nums){
            num = num^n;
        }
        int right =1;
        while((num&right)==0){
            right = right<<1;
        }
        List<Integer> oneList = new ArrayList<>();
        List<Integer> twoList = new ArrayList<>();
        int one=0;
        int two =0;
        for(int n:nums){
            if((n&right)==0){
                oneList.add(n);
            } else {
                twoList.add(n);
            }
        }
        for(int n:oneList){
            one^=n;
        }
        for(int n:twoList){
            two^=n;
        }
        return new int[]{one,two};
    }
}
