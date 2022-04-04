/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode8 {
    public int myAtoi(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        s= s.trim();
        if(s.length()==0){
            return 0;
        }
        int sign=1;
        if(s.charAt(0)=='-' || s.charAt(1) == '+'){
            if(s.charAt(0)=='-'){
                sign =-1;
            }
            s = s.substring(1,s.length());
        }
        return 0;

    }
}
