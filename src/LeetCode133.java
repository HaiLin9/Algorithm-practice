import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode133 {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node ==null){
            return null;
        }
        if(!map.containsKey(node)){
            map.put(node, new Node(node.val));
        }
        Node newNode = map.get(node);
        for(Node n:node.neighbors){
            if(map.containsKey(n)){
                newNode.neighbors.add(map.get(n));
            } else {
                newNode.neighbors.add(cloneGraph(n));
            }
        }
        return newNode;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
