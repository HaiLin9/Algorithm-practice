import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length -k+1];
        MaxQueue2 que = new MaxQueue2();
        for(int i=0 ; i<k;i++){
            que.push(nums[i]);
        }
        res[0]= que.max();
        for(int i=k,j=1;i< nums.length; i++){
            que.pop();
            que.push(nums[i]);
            res[j++]=que.max();
        }
        return res;
    }
}

class MaxQueue2 {
    Queue<Integer> queue ;
    Deque<Integer> deque ;
    MaxQueue2(){
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    void push(int val){
        queue.offer(val);
        while(!deque.isEmpty() && deque.peekLast()<val){
            deque.pollLast();
        }
        deque.offerLast(val);
    }

    int pop(){
        if (queue.isEmpty()){
            return -1;
        }
        int v= queue.poll();
        if(!deque.isEmpty() && deque.peekFirst() == v ){
            deque.pollFirst();
        }
        return v;
    }

    int max(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }
}
