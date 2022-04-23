import java.util.concurrent.*;

public class LeetCode171 {
    public int titleToNumber(String columnTitle) {
        ExecutorService e= new ThreadPoolExecutor(10, 10, 10l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        e.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        int res=0;
        int base=1;
        for(int i=columnTitle.length()-1; i>=0; i--) {
            int num = columnTitle.charAt(i) -'A' +1;
            res += num*base;
            base*=26;
        }
        return res;
    }
}
