public class LeetCode42 {
    /**
     * 暴力  o(n2)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int res =0;
        for(int i=1;i< height.length-1;i++){
            int leftMax=height[0];
            for(int j=0;j<i;j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax=height[height.length-1];
            for(int j=i+1;j< height.length;j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int max = Math.min(leftMax, rightMax);
            if(max>height[i]){
                res+=max-height[i];
            }
        }
        return res;
    }

    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if(height.length<3){
            return 0;
        }
        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];
        for(int i=1;i< height.length;i++){
            leftArr[i]=Math.max(height[i-1], leftArr[i-1]);
        }
        for(int i= height.length-2; i>=0; i--){
            rightArr[i] = Math.max(rightArr[i+1], height[i+1]);
        }
        int res =0;
        for(int i=1;i<height.length-1;i++){
            int max = Math.min(leftArr[i], rightArr[i]);
            if(max>height[i]){
                res+=max-height[i];
            }
        }
        return res;
    }

    public int trapV3(int[] height) {
        if(height.length<3){
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int left =0;
        int right = height.length-1;
        int res =0;
        while(left<right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax<=rightMax) {
                res+= leftMax-height[left];
                left++;
            } else {
                res+=rightMax-height[right];
                right--;
            }
        }
        return res;
    }

}
