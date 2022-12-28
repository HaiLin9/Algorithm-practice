/**
 * @author hailin6
 * @version 2022/1/11
 * 暴力解法
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        int max=1;
        int begin=0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+max-1;j<s.length();j++){
                if(j-i+1>max && isPalindrome(s,i,j)){
                    max = j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin, begin+max);
    }

    public boolean isPalindrome(String s, int left, int right) {
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
