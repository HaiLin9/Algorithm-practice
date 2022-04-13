import java.util.*;

public class LeetCode316 {
    public static String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> stack= new LinkedList<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(char c:s.toCharArray()){
            map.put(c, map.get(c)-1);
            if(set.contains(c)){
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>c && map.get(stack.peek())>0 ){
                char cc =stack.pop();
                set.remove(cc);
            }
            stack.push(c);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        removeDuplicateLetters("bbcaac");
    }
}
