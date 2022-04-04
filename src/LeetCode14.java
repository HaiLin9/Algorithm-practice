/**
 * @author hailin6
 * @version 2022/1/12
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String max = strs[0];
        for(int i=1;i<strs.length;i++){
            int len = Math.min(strs[i].length(), max.length());
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<len;j++){
                if(max.charAt(j)==strs[i].charAt(j)){
                    sb.append(max.charAt(j));
                } else {
                    break;
                }
            }
            max = sb.toString();
            if(max.length()==0){
                return "";
            }
        }
        return max;
    }
}
