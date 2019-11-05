package leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行?Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"?行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例?1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例?2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows =?4
 * 输出:?"LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode6 {
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0 || numRows==0){
            return "";
        }

        StringBuffer[] sbs = new StringBuffer[numRows];
        for(int i=0; i<numRows ;i++){
            sbs[i] = new StringBuffer();
        }

        int index = 0;
        boolean flag = true;
        for(int i = 0; i<s.length() ;i++){
            if(index==0){
                flag = true;
                sbs[0].append(s.charAt(i));
                index = index==numRows-1 ? 0:index+1;
            } else if(index==numRows-1){
                flag = false;
                sbs[index].append(s.charAt(i));
                index--;
            } else{
                if(flag){
                    sbs[index].append(s.charAt(i));
                    index++;
                } else{
                    sbs[index].append(s.charAt(i));
                    index--;
                }
            }
        }

        for(int i=1; i<numRows ;i++){
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
