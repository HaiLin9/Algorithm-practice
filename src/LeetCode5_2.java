/**
 * 动态规划
 */
public class LeetCode5_2 {
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i][i] = true;
        }
        for(int len =2; len<=s.length() ;len++){
            for(int i=0;i+len<=s.length();i++){
                int end = i+len-1;
                if(len<=3){
                    dp[i][end] = s.charAt(i) == s.charAt(end);
                } else {
                    dp[i][end] = s.charAt(i) == s.charAt(end) && dp[i+1][end-1];
                }
                if(len > max && dp[i][end]){
                    max =len;
                    start = i;
                }
            }
        }
        return s.substring(start, start+max);
    }
}
