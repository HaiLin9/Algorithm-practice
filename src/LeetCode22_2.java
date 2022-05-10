import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 广度优先遍历
 */
public class LeetCode22_2 {
    class Node {
        int left;
        int n;
        String path;
        Node(int left, int n, String path){
            this.left = left;
            this.n = n;
            this.path = path;
        }
    }
    public List<String> generateParenthesis(int n) {
        Deque<Node> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        queue.offer(new Node(0, n, ""));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.n==0) {
                while(node.left>0){
                    node.left--;
                    node.path = node.path + ")";
                }
                res.add(node.path);
            } else {
                if(node.left >0) {
                    queue.offer(new Node(node.left-1, node.n, node.path + ")" ));
                }
                queue.offer(new Node(node.left +1, node.n-1, node.path + "(" ));
            }
        }
        return res;
    }
}
