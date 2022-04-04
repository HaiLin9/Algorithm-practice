/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10 == 0)) {
            return false;
        }
        int y=0;
        while(x>y){
            y=y*10+x%10;
            x/=10;
        }
        if(x==y ||x==y/10){
            return true;
        } else{
            return false;
        }
    }
}
