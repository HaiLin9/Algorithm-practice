import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Offer38 {

    public String[] permutation(String s) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        permutation(res, "", s, visited);
        return res.toArray(new String[0]);
    }

    public void permutation(List<String> res, String path, String s, boolean[] visited) {
        if(path.length()==s.length()){
            res.add(path);
            return;
        }
        for(int i=0;i<s.length();i++) {
            Set<Character> set = new HashSet<>();
            if(!set.contains(s.charAt(i)) && !visited[i]) {
                visited[i] = true;
                set.add(s.charAt(i));
                permutation(res, path + path.charAt(i), s, visited);
                visited[i] =false;
            }
        }
    }
}
