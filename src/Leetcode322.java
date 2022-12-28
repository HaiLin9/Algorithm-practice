public class Leetcode322 {

    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        res[0]  =0;
        for(int i=1;i<=amount;i++){
            res[i] = -1;
            for(int coin:coins){
                if(i>=coin && res[i-coin]!=-1){
                    if(res[i]==-1){
                        res[i]=res[i-coin]+1;
                    } else {
                        res[i] = Math.min(res[i], res[i-coin]+1);
                    }
                }
            }
        }
        return res[amount];
    }
}
