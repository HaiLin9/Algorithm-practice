package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        } else if(s.length()<=1){
            return s;
        }

        int max = 1;
        int start = 0;
        int end = 0;
        boolean[][] result =new boolean[s.length()][s.length()];
        //初始条件
        for(int i=0; i<s.length() ;i++){
            result[i][i] = true;
            if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                result[i][i+1] = true;
                if(2>max){
                    max = 2;
                    start = i;
                    end = i+1;
                }
            }
        }

        for(int i=3; i<=s.length(); i++){
            for(int j=0; j+i-1 < s.length() ;j++){
                if(result[j+1][j+i-2] && s.charAt(j) == s.charAt(j+i-1)) {
                    result[j][j+i-1] = true;
                    if(i>max){
                        max = i;
                        start = j;
                        end = j+i-1;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
