package leetcode.string;

/**
 * Longest Substring Without Repeating Characters
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindrome {
    public static void main(String[] args){
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0 ;
        int end = 0;
        boolean[][] flag = new boolean[s.length()][s.length()];

        //初始化长度为1和长度为2的字符串
        for(int i = 0; i < s.length() ;i++) {
            flag[i][i] = true;
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                flag[i][i+1] = true;
                start = i;
                end = i+1;
            }
        }

        //处理长度为3及以上的字符串
        for(int curLength = 3; curLength<=s.length() ;curLength++){
            for(int i=0;i<=s.length()-curLength;i++){
                if(flag[i+1][i+curLength-2] && s.charAt(i)==s.charAt(i+curLength-1)){
                    flag[i][i+curLength-1] = true;
                    if(curLength > end -start +1) {
                        start = i;
                        end = i+ curLength-1;
                    }
                }
            }
        }

        return s.substring(start,end+1);

    }
}
