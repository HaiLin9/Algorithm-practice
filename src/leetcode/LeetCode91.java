package leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode91 {
    public int numDecodings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int[] result = new int[s.length()];
        result[0] = s.charAt(0) == '0' ? 0 :1;
        if(result[0]==0){
            return 0;
        }
        for(int i=1; i<s.length() ; i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1) =='0'){
                    return 0;
                } else if(s.charAt(i-1) >'2'){
                    return 0;
                } else{
                    result[i] = result[i-1];
                }
            } else {
                if(s.charAt(i-1) =='0'){
                    result[i] = result[i-1];
                } else if(Integer.parseInt(s.substring(i-1,i+1))<=26){
                    result[i] = result[i-1]+1;
                } else {
                    result[i] = result[i-1];
                }
            }
        }
        return result[s.length()-1];
    }
}
