/**
 * @author hailin6
 * @version 2022/1/7
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
       return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null || right==null) {
            return  left ==right;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetric(left.right, right.left) && isSymmetric(right.left, left.right);
    }

}
