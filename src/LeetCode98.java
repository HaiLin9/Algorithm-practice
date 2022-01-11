import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hailin6
 * @version 2022/1/6
 */


public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        if(root ==null){
            return true;
        }

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max){
        if (root ==null){
            return true;
        }
        if(root.val>=max || root.val<=min){
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        if(root ==null){
            return true;
        }
        int lastValue=Integer.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.pop();
            if(tmp.val<lastValue) {
                return false;
            }
            lastValue = tmp.val;
            root = root.right;
        }
        return true;
    }
}
