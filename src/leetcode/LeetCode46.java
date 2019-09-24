package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums==null || nums.length==0){
            return result;
        }

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
            curList.add(numsList.get(i));
            numsList.remove(i);
            permute(result,new ArrayList<>(curList),new ArrayList<>(numsList));
            numsList.add(i,curList.get(curList.size()-1));
            curList.remove(curList.size()-1);
        }
    }
}
