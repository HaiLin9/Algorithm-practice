package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> temp = new ArrayList<>();
        genIp(s, 0, temp);
        return result;
    }

    public void genIp(String remain, int index, List<String> temp){
        if(index >= 4) {
            if(remain.length()==0) {
                result.add(String.join(".", temp));
            }
            return;
        }
        for(int i=1; i<=3; i++) {
            if(remain.length()<i) {
                break;
            }
            String cur = remain.substring(0,i);
            if(!validIp(cur)){
                continue;
            }
            temp.add(cur);
            genIp(remain.substring(i, remain.length()), index+1 , temp);
            temp.remove(temp.size()-1);
        }
    }

    public boolean validIp(String s){
        if(s.length()<1||s.length()>3){
            return false;
        }
        if(s.startsWith("0") && s.length()>1){
            return false;
        }
        if(s.length()==3 && Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
}
