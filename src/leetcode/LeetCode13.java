package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LeetCode13 {
    public int romanToInt(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        for(int i=0; i<s.length() ;i++){
            if(i<s.length()-1 && map.containsKey(s.substring(i,i+2)) ){
                result += map.get(s.substring(i,i+2));
                i++;
            } else if(map.containsKey(s.substring(i,i+1))){
                result += map.get(s.substring(i,i+1));
            }
        }

        return result;


    }
}
