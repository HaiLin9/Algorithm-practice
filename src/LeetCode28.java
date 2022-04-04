/**
 * @author hailin6
 * @version 2022/1/18
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        if(needle ==null || needle.length()==0){
            return 0;
        }
        if(haystack ==null ||haystack.length()==0){
            return -1;
        }
        for(int i=0; i + needle.length()<haystack.length();i++){
            for(int j=0;j<needle.length();j++){
                if(i+j<haystack.length() &&haystack.charAt(i+j)==needle.charAt(j)){
                    if(j==needle.length()-1){
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
