import java.util.Arrays;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        int[] arrs = new int[26];
        for(char c :s.toCharArray()){
            arrs[c-'a'] +=1;
        }
        for(char c :t.toCharArray()){
            if(arrs[c-'a']==0){
                return false;
            }
            arrs[c-'a']-=1;
        }
        for(int num:arrs){
            if(num>0){
                return false;
            }
        }
        return true;

    }
}
