import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root !=null) {
            queue.offer(root);
        }
        int levelSize = 1;
        while(!queue.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int newLevelSize = 0;
            for(int i=1; i<=levelSize; i++) {
                TreeNode node = queue.poll();
                l.add(node.val);
                if(node.left !=null) {
                    queue.offer(node.left);
                    newLevelSize++;
                }
                if(node.right !=null) {
                    queue.offer(node.right);
                    newLevelSize++;
                }
            }
            levelSize = newLevelSize;
            res.add(l);
        }
        return res;
    }
}
