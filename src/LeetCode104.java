/**
 * @author hailin6
 * @version 2022/1/7
 */
public class LeetCode104 {

    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        maxDepth(root, 1);
        return maxDepth;
    }

    public void maxDepth(TreeNode root, int curDepth) {
        if(root == null){
            return;
        }
        maxDepth = Math.max(maxDepth, curDepth);
        int newDepth = curDepth+1;
        maxDepth(root.left, newDepth);
        maxDepth(root.right, newDepth);
    }
}
