/**
 * @author hailin6
 * @version 2022/1/11
 * 暴力解法
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        int max = 1;
        int start = 0; //记录最大的子串 的长度和起始位置。 避免记录子串不断开辟对象
        for(int i=0;i<s.length();i++){
            for(int j =i+1; j<s.length(); j++){
                //  当前子串比最大的回文子串大，才进行判断，进行剪枝优化
                if(j-i+1>max && isPalindrome(s, i, j)){
                    max = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start+max);
    }

    public boolean isPalindrome(String s, int start, int end){
        boolean res =true;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return res;
    }
}
