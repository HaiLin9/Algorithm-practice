import java.util.ArrayList;
import java.util.List;

/**
 * @author hailin6
 * @version 2022/1/6
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> tmp) {
        if(root ==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(targetSum - root.val == 0){
                tmp.add(root.val);
                List<Integer> tmp2= new ArrayList<>(tmp);
                result.add(tmp2);
                tmp.remove(tmp.size()-1);
            }
        } else{
            if(root.left!=null) {
                tmp.add(root.val);
                pathSum(root.left, targetSum - root.val, result, tmp);
                tmp.remove(tmp.size()-1);
            }
            if(root.right!=null) {
                tmp.add(root.val);
                pathSum(root.right, targetSum - root.val, result, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
