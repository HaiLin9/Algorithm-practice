import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });
        res.add(intervals[0]);
        for(int i=1; i<intervals.length ;i++){
            if(intervals[i][0] <= res.get(res.size()-1)[1]) {
                int[] lastArr = res.get(res.size()-1);
                lastArr[1] = Math.max(lastArr[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
