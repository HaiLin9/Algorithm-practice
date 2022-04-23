import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<nums[mid+1]) {
                left= mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
