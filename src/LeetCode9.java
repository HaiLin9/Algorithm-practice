/**
 * @author hailin6
 * @version 2022/1/11
 * 普通解法
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        // 特殊情况： 当 x < 0 时，x 不是回文数。
        // 如果数字的最后一位是 0，为了使该数字为回文，则其第一位数字也应该是 0,只有 0 满足这一属性
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        // 将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
        // 但是，如果反转后的数字大于int.MAX，我们将遇到整数溢出问题。
        // 因此用long存储反转后的数字。
        long cur = 0;
        int back = x;
        while(x>0){
            cur = cur*10 + x%10;
            x/=10;
        }
        return cur == (long)back;
    }
}
