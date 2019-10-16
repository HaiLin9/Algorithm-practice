package leetcode;

/**
 * ����һ����������ԭ�ؽ���չ��Ϊ����
 *
 * ���磬����������
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * ����չ��Ϊ��
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
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
