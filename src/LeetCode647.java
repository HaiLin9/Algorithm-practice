public class LeetCode647 {
    public int countSubstrings(String s) {
        if(s.length() <=1){
            return s.length();
        }
        int res =0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i =0;i<s.length();i++) {
            dp[i][i] = true;
            res++;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) ==s.charAt(i+1)){
                dp[i][i+1] = true;
                res++;
            }
        }
        for(int l=3;l<=s.length();l++) {
            for(int i=0;i+l-1<s.length();i++) {
                if(s.charAt(i) == s.charAt(i+l-1) && dp[i+1][i+l-2]){
                    dp[i][i+l-1] = true;
                    res++;
                }
            }
        }
        return res;

    }
}
