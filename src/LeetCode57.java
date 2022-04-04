import java.util.ArrayList;
import java.util.List;

public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i=0;
        while(newInterval[0] > intervals[i][1]){
            res.add(intervals[i++]);
        }
        int leftNum = Math.min(newInterval[0], intervals[i][0]);
        while(intervals[i][1] < newInterval[1]){
            i++;
        }
        if(newInterval[1] < intervals[i][0]){
            res.add(new int[]{leftNum, newInterval[1]});
        } else {
            res.add(new int[]{leftNum, intervals[i][1]});
            i++;
        }
        for(; i<intervals.length; i++){
            res.add(intervals[i]);
        }
        return res.toArray(new int[0][0]);
    }
}
