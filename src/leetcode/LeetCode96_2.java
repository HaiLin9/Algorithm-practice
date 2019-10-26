package leetcode;

/**
 * http://www.newsmth.net/nForum/#!article/Career_Upgrade/597745
 */
public class LeetCode96_2 {
    public int numTrees(int n) {
        int[][] arr = new int[n+1][n+1];
        return numTrees(1,n,arr);
    }

    public int numTrees(int start,int end, int[][] arr){
        int result=0;
        if(start==end || start>end){
            return 1;
        } else{
            if(arr[start][end]!=0){
                return arr[start][end];
            } else{
                for(int i=start; i<=end; i++){
                    result += numTrees(start,i-1,arr) * numTrees(i+1,end,arr);
                }
                arr[start][end] = result;
                return result;
            }
        }
    }
}
