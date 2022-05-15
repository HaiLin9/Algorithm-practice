import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode12 {
    public String intToRoman(int num) {
        String[] rome = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] bases = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder res = new StringBuilder();
        while(num>0){
            int index = bases.length-1;
            while(bases[index] > num){
                index--;
            }
            int dup = num / bases[index];
            num -= bases[index] * dup;
            while(dup-->0){
                res.append(rome[index]);
            }
        }
        return res.toString();

    }
}
