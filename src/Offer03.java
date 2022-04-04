public class Offer03 {
    public static int findRepeatNumber(int[] nums) {
        for(int i=0; i<nums.length ;i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]] ){
                    return nums[i];
                } else {
                    int temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[temp] = temp;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
    }
}
