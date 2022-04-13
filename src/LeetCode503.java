import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] temp = new int[nums.length];
        Arrays.fill(temp, -1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<2*nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i% nums.length]) {
                temp[stack.pop()] = nums[i% nums.length];
            }
            stack.push(i% nums.length);
        }
        return temp;
    }
}
