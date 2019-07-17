/**
 * 十进制转二进制
 */
public class DecimalToBinary {
    public static void main(String[] args){
        int num = 10;
        System.out.println(decimalToBinary(num));
    }

    public static String decimalToBinary(int num){
        StringBuffer sb = new StringBuffer();
        while(num>0){
            sb.append(num%2);
            num/=2;
        }
        return sb.reverse().toString();
    }
}
