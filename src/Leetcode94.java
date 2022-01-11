import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hailin6
 * @version 2022/1/5
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class Leetcode94 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.add(0, root);
        while(!stack.isEmpty()){
            TreeNode curNode = stack.get(0);
            if (curNode.left != null) {
                while(curNode.left != null) {
                    stack.add(0, curNode.left);
                    TreeNode origin = curNode;
                    curNode = curNode.left;
                    origin.left = null;
                }
            } else if(curNode.right == null) {
                result.add(curNode.val);
                stack.remove(0);
            } else {
                result.add(curNode.val);
                stack.remove(0);
                stack.add(0, curNode.right);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root= root.left;
            }
            TreeNode tn = stack.pop();
            res.add(tn.val);
            root = tn.right;
        }
        return res;
    }


}
