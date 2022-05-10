public class LeetCode42 {

    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int res =0;
        for(int i=1;i< leftMax.length;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }
        for(int i= rightMax.length-2; i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        for(int i=1;i< height.length-1;i++){
            int small = Math.min(leftMax[i], rightMax[i]);
            if(small > height[i]){
                res += small - height[i];
            }
        }
        return res;
    }
}
