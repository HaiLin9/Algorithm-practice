package leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void combinationSum(int[] candidates, int target, List<Integer> list, int sum){
        if(sum > target) {
            return;
        } else if(sum == target) {
            result.add(new ArrayList<>(list));
            return;
        } else {
            if(list.size()==0){
                for(int i:candidates){
                    list.add(i);
                    combinationSum(candidates,target,list,sum+i);
                    list.remove(list.size()-1);
                }
            } else {
                for(int i:candidates){
                    if(i>=list.get(list.size()-1)){
                        if(sum+i>target) {
                            break;
                        }
                        list.add(i);
                        combinationSum(candidates,target,list,sum+i);
                        list.remove(list.size()-1);
                    }
                }
            }
        }
    }
}
