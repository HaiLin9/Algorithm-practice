import java.util.*;

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeft = true;
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            Deque<Integer> que = new LinkedList<>();
            int size = queue.size();
            for(int i=1;i<= size;i++) {
                TreeNode node = queue.poll();
                if(isLeft) {
                    que.offer(node.val);
                } else {
                    que.offerFirst(node.val);
                }
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            isLeft = !isLeft;
            res.add(new LinkedList<>(que));
        }
        return res;

    }
}
