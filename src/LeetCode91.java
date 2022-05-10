import java.util.HashSet;
import java.util.Set;

public class LeetCode91 {
    public int numDecodings(String s) {
        int[] dp =new int[s.length()+1];
        dp[0] = 1;
        for(int i=1; i<=s.length(); i++){
            if(s.charAt(i-1)<='9' && s.charAt(i-1)>='1'){
                dp[i] += dp[i-1];
            }
            if(i>1){
                int two = Integer.parseInt(s.substring(i-2,i));
                if(two>=10 && two<=26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
}
