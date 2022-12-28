import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode next = stack.pop();
            res.add(next.val);
            if(next.left!=null){
               stack.add(next.left);
            }
            if(next.right!=null){
                stack.add(next.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
