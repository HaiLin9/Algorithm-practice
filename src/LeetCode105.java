import java.util.ArrayList;
import java.util.List;

public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        List<Integer> li = new ArrayList<>();
        li.add(1);
        TreeNode root =new TreeNode(preorder[0]);
        int index =findIndex(inorder,preorder[0]);
        if(index==0){
            root.left = null;
        } else {
            int[] newPreOrder = new int[index];
            System.arraycopy(preorder,1,newPreOrder,0,index);
            int[] newInorder = new int[index];
            System.arraycopy(inorder,0,newInorder,0,index);
            root.left = buildTree(newPreOrder, newInorder);
        }
        if(index == inorder.length-1){
            root.right = null;
        } else{
            int[] newPreOrder = new int[inorder.length - index -1];
            System.arraycopy(preorder,1+index,newPreOrder,0,newPreOrder.length);
            int[] newInorder = new int[inorder.length - index -1];
            System.arraycopy(inorder,1+index,newInorder,0,newPreOrder.length);
            root.right = buildTree(newPreOrder, newInorder);
        }
        return root;
    }

    public int findIndex(int[] order, int num){
        if(order == null || order.length==0) {
            return -1;
        }
        for (int i=0; i<order.length; i++) {
            if(order[i]==num){
                return i;
            }
        }
        return -1;
    }
}
