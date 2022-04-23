public class LeetCode208 {


}

class Trie {
    Trie[] children;
    boolean isEnd;
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(char c:word.toCharArray()) {
            if(node.children[c-'a'] == null) {
                node.children[c-'a'] = new Trie();
            }
            node = node.children[c-'a'];
        }
        node.isEnd =true;
    }

    public boolean search(String word) {
        Trie node = this;
        for(char c:word.toCharArray()) {
            node = node.children[c-'a'];
            if(node ==null) {
                return false;
            }
        }
        if(node.isEnd){
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char c:prefix.toCharArray()) {
            node = node.children[c-'a'];
            if(node ==null) {
                return false;
            }
        }
        return true;
    }
}
