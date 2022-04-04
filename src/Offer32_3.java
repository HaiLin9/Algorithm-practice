import java.util.*;

public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root !=null) {
            queue.offer(root);
        }
        boolean isOrder = true;
        while(!queue.isEmpty()) {
            List<Integer> temp= new ArrayList<>();
            int size = queue.size();
            while(size-->0) {
                TreeNode node =queue.pollFirst();
                if(isOrder){
                    temp.add(node.val);
                }else {
                    temp.add(0,node.val);
                }
                if(node.left != null){
                    queue.offerLast(node.right);
                }
                if(node.right != null){
                    queue.offerLast(node.right);
                }
            }
            res.add(temp);
            isOrder =!isOrder;
        }
        return res;
    }
}
