/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode12 {
    public String intToRoman(int num) {
        int[] bases = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] alphas = {"I", "IV","V","IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder res = new StringBuilder();
        while(num>0){
            int i=0;
            while(i<bases.length && bases[i]<= num) {
                i++;
            }
            i--;
            int bei = num / bases[i];
            for(int j=1;j<=bei;j++){
                res.append(alphas[i]);
            }
            num -= bei* bases[i];
        }
        return res.toString();

    }
}
