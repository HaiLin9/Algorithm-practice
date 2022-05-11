public class LeetCode45_2 {
    public static int jump(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int res =0; //一共跳了多少次
        int index = 0; // 每次起跳的位置
        while(index<nums.length-1) {
            if(index + nums[index]>= nums.length-1) {
                return res +1;
            }
            int max = index +1;  // 二次跳跃的最远距离
            int maxIndex = index +1; // 下一个index
            for(int i=index+1;i<=index+nums[index];i++){
                if(i+nums[i]>max){
                    max= i+nums[i];
                    maxIndex = i;
                }
            }
            index = maxIndex;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        jump(new int[]{1,2,3});
    }
}