package leetcode;

/**
 * LCS问题
 * Description
 * 中文
 * English
 * 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 *
 * Have you met this question in a real interview?
 * Clarification
 * 最长公共子序列的定义：
 *
 * 最长公共子序列问题是在一组序列（通常2个）中找到最长公共子序列（注意：不同于子串，LCS不需要是连续的子串）。
 * https://www.lintcode.com/problem/longest-common-subsequence/description
 */
public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int len1 = A.length();
        int len2 = B.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
