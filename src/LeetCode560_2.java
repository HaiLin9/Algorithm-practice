public class LeetCode560_2 {
    public static int subarraySum(int[] nums, int k) {
        int res =0;
        for(int i=0;i<nums.length;i++){
            int temp =0;
            for(int j=i;j<nums.length;j++){
                temp+=nums[j];
                if(temp == k){
                    res++;
                }
            }
        }
        return  res;
    }

    public static void main(String[] args){
        int[] test ={1,-1,0};
        int i= subarraySum(test, 0);
    }
}
