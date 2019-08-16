package leetcode.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 */
public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs ==null || strs.length==0){
            return "";
        }
        String common = strs[0];
        for(String s:strs){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<Math.min(common.length(), s.length());i++){
                if(common.charAt(i)==s.charAt(i)) {
                    sb.append(common.charAt(i));
                } else {
                    break;
                }
            }
            common = sb.toString();
        }
        return common;
    }
}
