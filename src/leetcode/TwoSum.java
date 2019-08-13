package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args){
        int[] test = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(test,9)));
    }

    public static int[] twoSum(int[] arr, int target) {
        int[] result = null;
        Map<Integer,Integer> temp = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(temp.containsKey(target-arr[i])){
                result = new int[] {i, temp.get(target-arr[i])};
                return result;
            }
            temp.put(arr[i],i);
        }
        return result;
    }
}
