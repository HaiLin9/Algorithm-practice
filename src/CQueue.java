import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            return  stack2.pop();
        } else if(stack1.isEmpty()) {
            return -1;
        } else {
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            return  stack2.pop();
        }
    }

}
