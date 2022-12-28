import java.util.ArrayList;
import java.util.List;

public class Offer57_2 {
    public int[][] findContinuousSequence(int target) {
        int left =1;
        int right=1;
        int sum =1;
        List<int[]> res = new ArrayList<>();
        while(left<=target/2){
            if(sum==target){
                int[] one =new int[right-left+1];
                for(int i=left;i<=right;i++){
                    one[i-left] = i;
                }
                res.add(one);
                sum-=left;
                left++;
                right++;
                sum+=right;
            } else if(sum<target) {
                right++;
                sum+=right;
            } else {
                sum-=left;
                left++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
