package leetcode;

/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode516 {

    public int longestPalindromeSubseq(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i] = 1;
        }

        for(int i=s.length()-2; i>=0; i--) {
            for(int j=i+1; j<s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(i==j-1){
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i+1][j-1] +2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
