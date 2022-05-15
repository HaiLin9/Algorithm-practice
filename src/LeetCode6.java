/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i=0;i<res.length;i++){
            res[i] = new StringBuilder();
        }
        int index =0;
        int row = 0;
        boolean down = true;
        while(index<s.length()){
            res[row].append(s.charAt(index++));
            if(down) {
                if(row == numRows-1){
                    down = false;
                    row--;
                } else {
                    row++;
                }
            } else {
                if(row == 0){
                    down = true;
                    row++;
                } else {
                    row--;
                }
            }
        }
        StringBuilder re = new StringBuilder();
        for(StringBuilder sb : res){
            re.append(sb);
        }
        return re.toString();
    }
}
