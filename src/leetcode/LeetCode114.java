package leetcode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode114 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        while(root != null) {
            if(root.left==null){
                root = root.right;
            } else{
                TreeNode right = root.left;
                while(right.right!=null) {
                    right = right.right;
                }
                right.right = root.right;
                root.right = root.left;
                root.left=null;
                root = root.right;
            }
        }
    }
}
