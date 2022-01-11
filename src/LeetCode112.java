/**
 * @author hailin6
 * @version 2022/1/6
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root ==null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(targetSum - root.val ==0){
                return true;
            } else {
                return false;
            }
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum- root.val);
    }
}
