/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode13 {
    public int romanToInt(String s) {
        int[] bases = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] alphas = {"I", "IV","V","IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int res = 0;
        for(int i=0;i<s.length();) {
            for(int j=alphas.length-1;j>=0;j--){
                if(s.indexOf(alphas[j], i) == i){
                    res+=bases[j];
                    i+=alphas[j].length();
                }
            }
        }
        return res;
    }
}
