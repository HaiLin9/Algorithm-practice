package leetcode;

public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length ==0){
            return "";
        }
        String longestCommon = strs[0];
        for(int i=1; i<strs.length ;i++){
            int j=0;
            while(j<longestCommon.length() && j<strs[i].length()){
                if(longestCommon.charAt(j)==strs[i].charAt(j)) {
                    j++;
                } else{
                    break;
                }
            }
            if(j==0){
                longestCommon = "";
                break;
            }
            longestCommon = longestCommon.substring(0,j);
        }
        return longestCommon;
    }
}
