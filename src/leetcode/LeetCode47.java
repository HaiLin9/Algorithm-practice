package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums==null || nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<>();
        for(int num:nums){
            numsList.add(num);
        }

        List<Integer> curList=  new ArrayList<>();
        permute(result,curList,numsList);
        return result;


    }

    private void permute(List<List<Integer>> result, List<Integer> curList, List<Integer> numsList){
        if(numsList.size()<1){
            result.add(new ArrayList<>(curList));
            return;
        }
        for(int i=0; i<numsList.size(); i++){
            if(i>0 && numsList.get(i).equals(numsList.get(i-1))){
                continue;
            }
            curList.add(numsList.get(i));
            numsList.remove(i);
            permute(result,new ArrayList<>(curList),new ArrayList<>(numsList));
            numsList.add(i,curList.get(curList.size()-1));
            curList.remove(curList.size()-1);
        }
    }
}
