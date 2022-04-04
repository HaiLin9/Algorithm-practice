/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max = Math.min(height[i],height[j]) * (j-i);
        while(i<j){
            if((Math.min(height[i],height[j]) * (j-i)) > max){
                max = Math.min(height[i],height[j]) * (j-i);
            }
            if(height[i]<height[j]){
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
