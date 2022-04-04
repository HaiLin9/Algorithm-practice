public class LeetCode67 {
    public String addBinary(String a, String b) {
        StringBuffer res =new StringBuffer();
        int carry=0;
        for(int i=a.length()-1,j=b.length()-1; i>=0||j>=0 ;i--,j--){
            int sum = carry;
            sum += i>=0 && a.charAt(i)=='1'?1:0;
            sum += j>=0 && b.charAt(j)=='1'?1:0;
            carry = sum >=2?1:0;
            res.append(sum%2==1?'1':'0');
        }
        res.append(carry==1?'1':"");
        return res.reverse().toString();
    }
}
