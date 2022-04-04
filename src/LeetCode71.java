import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LeetCode71 {

    public static String simplifyPath(String path) {
        String[] arr= path.split("/");
        Deque<String> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for(String name:arr){
            if(name.equals("..")){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            } else if(name.length()>0 && !name.equals(".")) {
                stack.offerLast(name);
            }
        }
        if(stack.isEmpty()){
            sb.append("/");
        } else {
            while(!stack.isEmpty()){
                sb.append("/");
                sb.append(stack.pollFirst());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        simplifyPath("/home/");
    }
}
