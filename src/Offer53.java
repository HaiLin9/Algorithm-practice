public class Offer53 {
    public static int search(int[] nums, int target) {
        int leftIndex = search(nums, target, true);
        int rightIndex = search(nums, target,false)-1;
        if(leftIndex<= rightIndex && rightIndex<nums.length && nums[leftIndex]==target&&nums[rightIndex]==target ){
            return rightIndex -leftIndex +1;
        }
        return 0;

    }

    public static int search(int[] nums, int target, boolean equal){
        int left = 0;
        int right = nums.length-1;
        int ans = nums.length;
        while(left<=right){
            int mid = (left +right) /2;
            if(nums[mid]>target ||(equal && nums[mid]>=target)){
                right = mid-1;
                ans= right;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        search(nums, 8);
    }
}
