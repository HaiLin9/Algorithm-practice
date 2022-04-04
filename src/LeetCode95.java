public class LeetCode95 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2==null || text1.length() ==0 || text2.length()==0){
            return 0;
        }
        int m = text1.length(), n= text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            char a = text1.charAt(i-1);
            for(int j =1; j<=n ;j++) {
                char b = text2.charAt(j-1);
                if(a==b){
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return  dp[m][n];

    }
}
