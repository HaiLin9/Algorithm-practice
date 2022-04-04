import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left =0, right = matrix[0].length-1;
        int top =0, bottom = matrix.length-1;
        while(left <= right && top <= bottom) {
            if(left == right && top == bottom){
                res.add(matrix[top][left]);
                break;
            }
            if(left == right){
                for(int j =top;j<=bottom;j++){
                    res.add(matrix[j][left]);
                }
                break;
            }
            if(top == bottom){
                for(int j =left;j<=right;j++){
                    res.add(matrix[top][j]);
                }
                break;
            }
            for(int i=left;i<right;i++) {
                res.add(matrix[top][i]);
            }
            for(int j=top;j<bottom;j++){
                res.add(matrix[j][right]);
            }
            for(int i=right;i>left;i--){
                res.add(matrix[bottom][i]);
            }
            for(int j=bottom; j>top ;j--){
                res.add(matrix[j][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
