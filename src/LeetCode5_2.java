/**
 * 动态规划
 */
public class LeetCode5_2 {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        int max =1;
        int begin =0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i] = true;
        }
        for(int len=2; len<=s.length(); len++){
            for(int start=0;start+len-1<s.length();start++){
                if(s.charAt(start)== s.charAt(start+len-1) && (len<=3||dp[start+1][start+len-2])){
                    dp[start][start+len-1] = true;
                    if(len>max){
                        max=len;
                        begin = start;
                    }
                }
            }
        }
        return s.substring(begin,begin+max);
    }
}
