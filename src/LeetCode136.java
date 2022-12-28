public class LeetCode136 {

    public int singleNumber(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int res=0;
        for(int num:nums) {
            res = res ^ num;
        }
        return res;

    }
}
