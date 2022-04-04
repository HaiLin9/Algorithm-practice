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
        List<String> res = new ArrayList<>();
        if(digits ==null ||digits.length()==0){
            return res;
        }
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
        letterCombinations(phoneMap, res, "", digits);
        return res;
    }

    public void  letterCombinations(final Map<Character, String> phoneMap,List<String> res, String cur, String digits) {
        if(digits.length()==1){
            char first = digits.charAt(0);
            String all = phoneMap.get(first);
            for(char a:all.toCharArray()){
                res.add(cur + a);
            }
        } else {
            char first = digits.charAt(0);
            String all = phoneMap.get(first);
            for(char a:all.toCharArray()){
                letterCombinations(phoneMap, res, cur + a, digits.substring(1));
            }
        }
    }
}
