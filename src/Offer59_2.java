import java.util.*;

public class Offer59_2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for(int i=0;i<k-1;i++){
            queue.add(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length-k+1];
        for(int i=k-1,j=0;i< nums.length;i++,j++){
            queue.add(new int[]{nums[i], i});
            int[] first = queue.peek();
            while(i-k+1>first[1]){
                queue.poll();
                first = queue.peek();
            }
            res[j] = first[0];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
