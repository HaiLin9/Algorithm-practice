public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int[] res = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            int n1 = num1.charAt(i) - '0';
            for(int j=num2.length()-1; j>=0; j--){
                int n2 = num2.charAt(j) - '0';
                int num = n1*n2;
                res[i+j+1] += num;
            }
        }
        for(int i=res.length-1;i>0;i--){
            if(res[i]>=10){
                res[i-1] += res[i]/10;
                res[i] = res[i] %10;
            }
        }
        int index = res[0] ==0?1: 0;
        StringBuilder sb = new StringBuilder();
        while(index< res.length){
            sb.append(res[index++]);
        }
        return sb.toString();
    }
}
