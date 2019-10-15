package leetcode;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode105 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null ||preorder.length==0) {
            return null;
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if (p_start > p_end) {
            return null;
        }
        int rootVal = preorder[p_start];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = findIndex(inorder,rootVal);
        int leftNum = rootIndex - i_start;
        root.left = buildTree(preorder, p_start+1, p_start+leftNum, inorder, i_start, rootIndex-1);
        root.right = buildTree(preorder, p_start + leftNum + 1, p_end, inorder, rootIndex+1, i_end);
        return root;
    }

    public int findIndex(int[] arr, int value) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
