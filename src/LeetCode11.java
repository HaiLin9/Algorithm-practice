/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        // 关键字：左右两边
        // 需要移动两头的问题，需要考虑双指针
        int max = 0;
        int left=0;
        int right = height.length-1;
        while(left<right){
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if(height[left]<height[right]){
                left++;
            } else {
                right--;
            }
        }
        return  max;
    }
}
