public class Offer19 {

    public static boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i =0;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==0){
                    dp[i][j] = false;
                    continue;
                }
                if(p.charAt(j-1) == '*') {
                    if(s.charAt(i-1) ==p.charAt(j-2) ){
                        dp[i][j]=dp[i-1][j] || dp[i][j-2];
                    } else {
                        dp[i][j]= dp[i][j-2];
                    }
                } else {
                    if(isMatch(s.toCharArray(), p.toCharArray(), i-1, j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static boolean isMatch(char[] s, char[] p, int i, int j){
        if(p[j]=='.'){
            return true;
        }
        if(s[i] == p[j]){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        isMatch("aa","a*");
    }
}
