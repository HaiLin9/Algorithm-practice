/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode5 {

    public static String longestPalindrome(String s) {
        if(s.length()==0 || s.length()==1){
            return s;
        }
        String maxHui = "";
        boolean[][] tmp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            tmp[i][i] = true;
            if(1>maxHui.length()){
                maxHui = s.substring(i,i+1);
            }
        }
        for(int i=0;i+1<s.length();i++){
            if(s.charAt(i) == s.charAt(i+1)) {
                tmp[i][i+1] = true;
                if(2>maxHui.length()){
                    maxHui = s.substring(i,i+2);
                }
            }
        }
        for(int i=3;i<=s.length();i++){
            for(int j=0; j+i-1<s.length() ;j++){
                if(s.charAt(j) == s.charAt(j+i-1) && tmp[j+1][j+i-2]) {
                    tmp[j][j+i-1] = true;
                    if(i>maxHui.length()){
                        maxHui = s.substring(j,j+i);
                    }
                }
            }
        }
        return maxHui;

    }

    public static void main(String[] args) {
        longestPalindrome("cbbd");
    }
}
