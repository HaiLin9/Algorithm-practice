import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode862 {
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        Deque<Integer> queue = new LinkedList<>();
        for(int i =1;i<=len;i++){
            dp[i] = dp[i-1] + A[i-1];
        }
        int result = len+1;
        for(int i=0; i<=len ;i++){
            while(!queue.isEmpty() && dp[i]<=dp[queue.getLast()]){
                queue.removeLast();
            }
            while(!queue.isEmpty() && dp[i]-dp[queue.getFirst()]>=K) {
                result = Math.min(result, i-queue.removeFirst());
            }
            queue.addLast(i);
        }
        return result < len + 1? result : -1;
    }
}
