public class LeetCode42_2 {

    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int res =0;
        while(left<right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if(leftMax<=rightMax){
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
