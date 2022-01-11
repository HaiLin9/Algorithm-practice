/**
 * @author hailin6
 * @version 2022/1/7
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0, 0);
    }

    public int maxDepth(TreeNode root, int curDepth, int maxDepth) {
        if(root ==null){
            return maxDepth;
        }
        ++curDepth;
        int newMaxdepth = curDepth > maxDepth? curDepth: maxDepth;
        int leftMax = maxDepth(root.left, curDepth, newMaxdepth);
        int rightMax = maxDepth(root.right, curDepth, newMaxdepth);
        return leftMax>rightMax? leftMax: rightMax;
    }
}
