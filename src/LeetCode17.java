import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * @author hailin6
 * @version 2022/1/13
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res = new ArrayList<>();
        help(digits, 0, res, "", phoneMap);
        return res;
    }

    public void help(String digits, int index, List<String> res, String cur, Map<Character, String> phoneMap) {
        if(index==digits.length()){
            if (cur.length()>0){
                res.add(cur);
            }
            return;
        }
        String s = phoneMap.get(digits.charAt(index));
        for (char c:s.toCharArray()){
            cur = cur + c;
            help(digits, index+1, res, cur, phoneMap);
            cur = cur.substring(0, cur.length()-1);
        }
    }


}
