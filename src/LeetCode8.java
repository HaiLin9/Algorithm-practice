/**
 * @author hailin6
 * @version 2022/1/11
 */
public class LeetCode8 {
    public int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }
        int index = 0;
        int res = 0;
        // 去除前导空格，index指向第一个不为空格的下标
        while(index <s.length() && s.charAt(index)==' '){
            index++;
        }
        // 针对极端用例 "      "
        if(index == s.length()){
            return 0;
        }
        // 如果出现符号字符，仅第 1 个有效
        int sign =1;
        if(s.charAt(index) == '+'){
            index++;
        } else if(s.charAt(index) == '-'){
            index++;
            sign = -1;
        }
        // 将后续出现的数字字符进行转换
        while(index<s.length() && s.charAt(index)<='9' && s.charAt(index)>='0'){
            int num = s.charAt(index) - '0';
            // 判断溢出
            if(sign>0 && res>(Integer.MAX_VALUE-sign*num)/10) {
                return Integer.MAX_VALUE;
            }
            if(sign<0 && res<(Integer.MIN_VALUE-sign*num)/10) {
                return Integer.MIN_VALUE;
            }
            res = res*10 + sign*num;
            index++;
        }
        return res;
    }
}
