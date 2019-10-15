package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode113 {
    private List<List<Integer>> result= new ArrayList<>();

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp = new ArrayList<>();
        genPath(root,sum,temp);
        return result;
    }

    public void genPath(TreeNode root, int sum, List<Integer> temp) {
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null) {
            if(root.val==sum){
                temp.add(root.val);
                result.add(temp);
            }
            return;
        }

        if(root.left != null){
            int newSum = sum - root.val;
            temp.add(root.val);
            genPath(root.left, newSum, new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }

        if(root.right != null){
            int newSum = sum - root.val;
            temp.add(root.val);
            genPath(root.right, newSum, new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }
    }
}
