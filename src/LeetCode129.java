public class LeetCode129 {
    private int sum =0;

    public int sumNumbers(TreeNode root) {
        help(0, root);
        return sum;
    }

    public void help(int cur, TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left ==null&& root.right == null){
            sum += cur*10 + root.val;
            return;
        }
        if(root.left!=null){
            help(cur*10 + root.val, root.left);
        }
        if(root.right != null){
            help(cur*10 + root.val, root.right);
        }
    }
}
