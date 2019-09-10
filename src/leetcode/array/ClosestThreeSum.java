package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class ClosestThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        if(nums ==null || nums.length <3) {
            return -1;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length -1;
            while(left<right) {
                int cha = Math.abs(target - nums[i] - nums[left] - nums[right]);
                if(Math.abs(target-result)>cha) {
                    result=nums[i] + nums[left] + nums[right];
                }
                if(target - nums[i] - nums[left] - nums[right]>0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
