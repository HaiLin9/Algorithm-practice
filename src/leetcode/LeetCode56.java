package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode56 {
    public static void main(String[] args){
        int[][] input = {{1,3}};
        merge(input);
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0){
            return intervals;
        } else if(intervals.length==1){
            return intervals;
        }
        sortMultiArrayByFirst(intervals);
        List<int[]> result = new ArrayList<>();
        int[] lastArray = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=lastArray[1]){
                int left = lastArray[0];
                int right = Math.max(lastArray[1],intervals[i][1]);
                lastArray = new int[]{left,right};
            } else{
                result.add(lastArray);
                lastArray = intervals[i];
            }
            if(i==intervals.length-1){
                result.add(lastArray);
            }
        }
        int[][] result2 = new int[result.size()][];
        for(int i=0;i<result.size();i++){
            result2[i] = result.get(i);
        }
        return result2;
    }

    private static void sortMultiArrayByFirst(int[][] intervals){
        for(int i=1; i<intervals.length; i++) {
            for(int j=1; j<intervals.length-i+1 ;j++){
                if(intervals[j][0]<intervals[j-1][0]){
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j-1];
                    intervals[j-1] = temp;
                }
            }
        }
    }
}
