public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num =1;
        int left =0,right=n-1;
        int top=0, bottom=n-1;
        while(left <= right && top <= bottom){
            if(left == right && top==bottom){
                res[top][left] = num++;
                break;
            }
            for(int j=left;j<right;j++){
                res[top][j] = num++;
            }
            for(int i =top; i<bottom; i++){
                res[i][right] = num++;
            }
            for(int j=right;j>left;j--){
                res[bottom][j] = num++;
            }
            for(int i=bottom; i>top;i--){
                res[i][left] = num++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
