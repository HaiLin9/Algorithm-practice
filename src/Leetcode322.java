public class Leetcode322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<=amount;i++){
            dp[i] = -1;
            for(int coin: coins) {
                if(i>=coin && dp[i-coin]>-1) {
                    dp[i] = dp[i] == -1? dp[i-coin]+1: Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }
        return dp[amount];
     }
}
