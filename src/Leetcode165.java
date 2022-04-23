public class Leetcode165 {
    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i=0;
        while(i<s1.length ||i<s2.length){
            int num1 =0;
            if(s1.length>i) {
                num1 = Integer.parseInt(removeZero(s1[i]));
            }
            int num2 =0;
            if(s2.length>i) {
                num2 = Integer.parseInt(removeZero(s2[i]));
            }
            if(num1>num2){
                return 1;
            } else if(num1<num2){
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static String removeZero(String s) {
        int start =0;
        for(char c:s.toCharArray()){
            if(c!='0' ||start==s.length()-1){
                break;
            }
            start++;
        }
        return s.substring(start);
    }

    public static void main(String[] args) {
        compareVersion("0.1", "1.1");
    }
}
