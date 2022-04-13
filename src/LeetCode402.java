import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

public class LeetCode402 {
    public String removeKdigits(String num, int k) {
        if(k==num.length()) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();
        for(char c:num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()>c){
                k--;
                stack.pop();
            }
            stack.push(c);
        }
        while(k-->0){
            stack.pop();
        }
        while(stack.getLast()=='0' && stack.size()>1) {
            stack.pollLast();
        }
        char[] res = new char[stack.size()];
        int i=0;
        while(stack.size()>0){
            res[i++]= stack.pollLast();
        }
        return new String(res);
    }
}
