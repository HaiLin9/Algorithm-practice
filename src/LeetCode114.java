public class LeetCode114 {

    public void flatten(TreeNode root) {
        TreeNode cur =root;
        while(cur != null){
            if(cur.left!=null){
                TreeNode right = cur.right;
                TreeNode last = cur.left;
                while(last.right!=null){
                    last = last.right;
                }
                last.right = right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
