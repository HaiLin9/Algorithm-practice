/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if(numRows==1 || s==null || s.length()==1){
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[Math.min(numRows, s.length())];
        for(int i=0; i<sbs.length; i++){
            sbs[i] = new StringBuilder();
        }
        // 0下  1上
        int direct =0 ;
        int index =0 ;
        for(int i=0;i<s.length() ; i++){
            sbs[index].append(s.charAt(i));
            if(index == sbs.length-1 && direct==0){
                direct=1;
                index--;
            } else if(index ==0 && direct==1){
                direct=0;
                index++;
            } else if(direct==0){
                index++;
            } else{
                index--;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : sbs) {
            ret.append(row);
        }
        return ret.toString();
    }
}
