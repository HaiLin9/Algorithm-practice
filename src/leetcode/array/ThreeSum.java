package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums ==null || nums.length <3) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i-1]==nums[i]){ // 去重
                continue;
            }
            int left = i+1;
            int right = nums.length -1;
            int cha = 0-nums[i];
            while(left<right) {
                if(nums[left]+nums[right]==cha){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    break;
                } else if(nums[left]+nums[right]<cha){
                    left ++;
                } else if(nums[left]+nums[right]>cha){
                    right--;
                }
            }
        }
        return result;
    }
}
