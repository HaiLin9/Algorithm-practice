import java.util.Deque;
import java.util.LinkedList;

public class Offer59 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(queue.isEmpty()){
                queue.offerLast(i);
            } else {
                if(i-queue.getFirst()>=k){
                    queue.pollFirst();
                }
                while(!queue.isEmpty() && nums[i]>nums[queue.getLast()]){
                    queue.pollLast();
                }
                queue.offerLast(nums[i]);
            }
            if(i>=k-1) {
                res[i-k+1] = queue.getFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7,}, 3);
    }
}
