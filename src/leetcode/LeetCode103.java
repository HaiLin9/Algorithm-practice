package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode103 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root ==null) {
            return result;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while(!s1.empty() || !s2.empty()){
            List<Integer> l = new ArrayList<>();
            while(!s1.empty()) {
                TreeNode n = s1.pop();
                l.add(n.val);
                if(n.left != null){
                    s2.push(n.left);
                }
                if(n.right != null){
                    s2.push(n.right);
                }
            }
            if(l.size()>0){
                result.add(new ArrayList<>(l));
                l.clear();
            }
            while(!s2.empty()) {
                TreeNode n =s2.pop();
                l.add(n.val);
                if(n.right != null){
                    s1.push(n.right);
                }
                if(n.left != null){
                    s1.push(n.left);
                }
            }
            if(l.size()>0) {
                result.add(new ArrayList<>(l));
                l.clear();
            }
        }

        return result;
    }
}
