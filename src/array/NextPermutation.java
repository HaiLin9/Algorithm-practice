package array;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<=1){
            return;
        }
        int j = nums.length-2;

        while(j>=0){
            if(nums[j]<nums[j+1]){
                break;
            }
            j--;
            if(j<0){
                Arrays.sort(nums);
                return;
            }
        }

        int big = j+1;
        for(int i=big; i<nums.length; i++){
            if(nums[i] > nums[j] && nums[i] < nums[big]) {
                big = i;
            }
        }
        swap(nums,j,big);

        Arrays.sort(nums, j+1, nums.length);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
