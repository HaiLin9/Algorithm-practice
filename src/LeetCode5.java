/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode5 {

    public static String longestPalindrome(String s) {
        int max = 0;
        String maxHui = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i][i] = true;
            if(i-i+1>max){
                max= 1;
                maxHui = s.substring(i,i+1);
            }
        }
        for(int len = 2;len<=s.length();len++){
            for(int i=0;i+len-1<s.length();i++){
                int j = i+len-1;
                if(j-i<=2){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j] && len > max){
                    max =len;
                    maxHui = s.substring(i, j+1);
                }
            }
        }
        return maxHui;
    }

    public static void main(String[] args) {
        longestPalindrome("cbbd");
    }
}
