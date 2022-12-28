import java.util.*;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        Map<String, Boolean> map = new HashMap<>();
        for(String str:wordDict){
            wordSet.add(str);
        }
        return help(s, wordSet, 0, map);
    }

    public boolean help(String s, Set<String> wordDict, int startIndex, Map<String, Boolean> temp) {
        if(startIndex>=s.length()){
            return true;
        }
        if(temp.get(s.substring(startIndex))!=null){
            return false;
        }
        boolean ret = false;
        for(int i=startIndex;i<s.length();i++){
            String sub = s.substring(startIndex, i+1);
            if(wordDict.contains(sub)){
                ret = ret|help(s, wordDict, i+1,temp);
            }
        }
        if(!ret){
            temp.put(s.substring(startIndex), false);
        }
        return ret;
    }

}
