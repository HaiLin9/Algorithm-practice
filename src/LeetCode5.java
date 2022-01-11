/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if(s==null || s.length() <=1){
            return s;
        }
        String maxHui = "";
        boolean[][] tmp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            tmp[i][i] = true;
        }
        maxHui = s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                tmp[i][i+1] = true;
                if(maxHui.length()<2){
                    maxHui = s.substring(i,i+2);
                }
            }
        }
        for(int len=3;len<=s.length() ;len++){
            for(int i=0; i+len-1<s.length(); i++) {
                if(s.charAt(i) == s.charAt(i+len-1) && tmp[i + 1][i + len - 2]){
                    tmp[i][i+len-1] = true;
                    if(maxHui.length()<len){
                        maxHui = s.substring(i, i+len);
                    }
                }
            }
        }
        return maxHui;
    }
}
