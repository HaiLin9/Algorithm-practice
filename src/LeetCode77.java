import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        help(n,k,res, path, 1);
        return res;
    }

    public void help(int n, int k, List<List<Integer>> res, List<Integer> path, int startIndex){
        if (path.size()==k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i<=n; i++){
            path.add(i);
            help(n,k,res, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
