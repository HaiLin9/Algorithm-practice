import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hailin6
 * @version 2022/1/6
 * 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 思路与算法
 *
 * 我们需要考虑两个节点被错误地交换后对原二叉搜索树造成了什么影响。对于二叉搜索树，我们知道如果对其进行中序遍历，得到的值序列是递增有序的，
 * 而如果我们错误地交换了两个节点，等价于在这个值序列中交换了两个值，破坏了值序列的递增性。
 *
 * 我们来看下如果在一个递增的序列中交换两个值会造成什么影响。假设有一个递增序列 a=[1,2,3,4,5,6,7]a=[1,2,3,4,5,6,7]。如果我们交换两个不相邻的数字，例如 22 和 66，原序列变成了 a=[1,6,3,4,5,2,7]a=[1,6,3,4,5,2,7]，那么显然序列中有两个位置不满足 a_i<a_{i+1}a
 * i
 * ​
 *  <a
 * i+1
 * ​
 *  ，在这个序列中体现为 6>36>3，5>25>2，因此只要我们找到这两个位置，即可找到被错误交换的两个节点。如果我们交换两个相邻的数字，例如 22 和 33，此时交换后的序列只有一个位置不满足 a_i<a_{i+1}a
 * i
 * ​
 *  <a
 * i+1
 * ​
 *  。因此整个值序列中不满足条件的位置或者有两个，或者有一个。
 *
 */
public class LeetCode99 {

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode x = null;
        TreeNode y =null;
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode tmp =stack.pop();
            list.add(tmp);
            root = tmp.right;
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).val>list.get(i+1).val){
                if(x==null){
                    x= list.get(i);
                }
                y =list.get(i+1);
            }
        }
        if(x!=null && y!=null){
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
}
