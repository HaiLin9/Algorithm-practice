import java.util.Arrays;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {

        int[] copy = new int[nums.length];
        int left=0;
        ReentrantLock lock =new ReentrantLock();
        lock.lock();
        int right =nums.length-1;
        System.arraycopy(nums,0,copy,0,nums.length);
        Arrays.sort(copy);
        while(left<right && copy[left]==nums[left]){
            left++;
        }
        while(left<right && copy[right]==nums[right]){
            right--;
        }
        if(left == right){
            return 0;
        } else {
            return right -left+1;
        }
    }
}
