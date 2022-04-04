/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        StringBuffer[] sbs = new StringBuffer[numRows];
        for(int i=0;i<sbs.length;i++){
            sbs[i] = new StringBuffer();
        }
        int status = 0; //0 down
        int curRow = 0;
        for(char c:s.toCharArray()) {
            sbs[curRow].append(c);
            if(status ==0 ){
                if(curRow==numRows-1) {
                    status = 1;
                    curRow = numRows==1? 0:curRow-1;
                } else {
                    curRow++;
                }
            } else {
                if(curRow==0) {
                    status = 0;
                    curRow = numRows==1? 0:1;
                } else {
                    curRow--;
                }
            }
        }
        StringBuffer res = new StringBuffer();
        for(StringBuffer sb:sbs) {
            res.append(sb);
        }
        return  res.toString();
    }
}
