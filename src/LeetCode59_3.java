import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode59_3 {
}

class MaxQueue {
    Deque<Integer> deque;
    Queue<Integer> queue;

    public MaxQueue() {
        deque = new LinkedList<>();
        queue= new LinkedList<>();
    }

    public int max_value() {
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast()<value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int v = queue.poll();
        if(!deque.isEmpty() && v == deque.peekFirst()){
            deque.pollFirst();
        }
        return v;
    }
}
