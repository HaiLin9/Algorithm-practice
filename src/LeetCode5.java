/**
 * @author hailin6
 * @version 2022/1/11
 * 暴力解法
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = s.substring(0, 1);
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        for(int len=2;len<=s.length();len++){
            for(int i=0;i+len-1<s.length();i++){
                if(s.charAt(i)==s.charAt(i+len-1)){
                    if(len<=3){
                        dp[i][i+len-1]=true;
                    } else {
                        dp[i][i+len-1] = dp[i+1][i+len-2];
                    }
                } else {
                    dp[i][i+len-1]=false;
                }
                if(dp[i][i+len-1] && len>res.length()){
                    res = s.substring(i, i+len);
                }
            }
        }
        return  res;
    }


}
