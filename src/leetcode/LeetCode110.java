package leetcode;

/**
 * ����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
 *
 * �����У�һ�ø߶�ƽ�����������Ϊ��
 *
 * һ��������ÿ���ڵ�?���������������ĸ߶Ȳ�ľ���ֵ������1��
 *
 * ʾ�� 1:
 *
 * ���������� [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���� true ��
 *
 * ʾ�� 2:
 *
 * ���������� [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * ����?false ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/balanced-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode110 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root){
        if(root == null) {
            return true;
        }
        if(Math.abs(depth(root.left)-depth(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) +1;
    }
}
