import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        help(res, path, k,n,0,1);
        return res;
    }

    public static void help(List<List<Integer>> res, List<Integer> path, int k, int n, int curSum, int start) {
        if(path.size()==k){
            if(curSum==n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=start;i<=9;i++) {
            path.add(i);
            help(res, path, k, n, curSum+i, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        combinationSum3(3, 7);
    }
}
