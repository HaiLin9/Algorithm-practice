public class LeetCode168 {
    public static String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber>0){
            char cur = (char)('A' + columnNumber %26 -1);
            sb.append(cur);
            columnNumber= (columnNumber-columnNumber %26) / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        convertToTitle(701);
    }
}
