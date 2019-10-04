package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        genSets(results,nums,0,cur);
        return results;
    }

    public void genSets(List<List<Integer>> results, int[] nums, int index, List<Integer> cur){
        if(index==nums.length-1){
            results.add(new ArrayList<>(cur));
            List<Integer> newCur = new ArrayList<>(cur);
            newCur.add(nums[index]);
            results.add(new ArrayList<>(newCur));
        } else if(index<nums.length-1){
            genSets(results,nums,index+1,cur);
            List<Integer> newCur = new ArrayList<>(cur);
            newCur.add(nums[index]);
            genSets(results,nums,index+1,newCur);
        }
    }
}
