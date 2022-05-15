/**
 * 反转一半数字
 */
public class LeetCode9_2 {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0) && x!= 0 ){
            return false;
        }
        int cur =0;
        // 问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？
        // 由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
        while(x>cur){
            cur = cur*10 +x%10;
            x/=10;
        }
        return x == cur || x==cur/10;
    }
}
