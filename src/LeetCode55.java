public class LeetCode55 {
    public static boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length-1;i++){
            if(max >= i) {
                max = Math.max(max, i+nums[i]);
            }
            if(max>=nums.length-1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        canJump(arr);
    }
}
