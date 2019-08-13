package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstrWithoutRepeat {

    public static void main(String[] args){
        System.out.println(longestSubstrWithoutRepeat("abcabcbb"));
    }

    public static int longestSubstrWithoutRepeat(String s){
        int result = 0;
        int left =0;
        int right =0;
        Map<Character,Integer> temp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(temp.containsKey(c)) {
                left = temp.get(c) + 1;
                right=i;
            } else {
                right =i;
                temp.put(c,i);
                result = Math.max(result, right -left +1);
            }
        }
        return result;
    }
}
