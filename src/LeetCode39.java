import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        help(res, path, target, 0, candidates, 0);
        return res;
    }

    public void help(List<List<Integer>> res, List<Integer> path, int target, int curSum,int[] candidates,int start){
        if(curSum>=target){
            if(curSum==target){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int  i=start;i< candidates.length;i++){
            path.add(candidates[i]);
            help(res, path, target, curSum+candidates[i], candidates, i);
            path.remove(path.size()-1);
        }
    }
}
