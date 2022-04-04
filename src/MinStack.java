import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    /** initialize your data structure here. */
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> min = new LinkedList<>();
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek()>= x){
            min.push(x);
        }
    }

    public void pop() {
        int i=stack.pop();
        if(min.peek().equals(i)){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
