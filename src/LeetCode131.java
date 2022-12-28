import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        help(res, path, s, 0);
        return res;
    }

    public void help(List<List<String>> res, List<String> path, String s, int startIndex){
        if(startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(!isPa(s, startIndex, i)){
                continue;
            }
            path.add(s.substring(startIndex, i+1));
            help(res, path, s, i+1);
            path.remove(path.size()-1);
        }
    }

    public boolean isPa(String s, int left, int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
