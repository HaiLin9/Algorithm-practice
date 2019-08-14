package leetcode.string;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 */
public class ZTransform {
    public static void main(String[] args){
        System.out.println(zTransform("LEETCODEISHIRING",3));
    }

    public static String zTransform(String s,int numROws){
        if(s==null || s.length()==0){
            return "";
        }
        numROws = Math.min(numROws,s.length());
        StringBuilder[] sbs = new StringBuilder[numROws];

        for(int i=0;i<numROws;i++){
            sbs[i]=new StringBuilder();
        }
        boolean direct = true;
        int index =0 ;
        for(int i=0;i<s.length();i++){
            sbs[index].append(s.charAt(i));
            if(direct){
                index++;
            } else {
                index--;
            }
            if(index==numROws-1){
                direct = false;
            } else if(index==0){
                direct =true;
            }
        }
        StringBuilder res =new StringBuilder();
        for(StringBuilder sb:sbs){
            res.append(sb);
        }
        return res.toString();
    }
}
