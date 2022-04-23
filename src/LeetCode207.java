import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        int[] inDegrees = new int[numCourses];
        for(int[] arr:prerequisites){
            inDegrees[arr[0]]++;
        }
        for(int i=0; i<numCourses ;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] arr:prerequisites) {
            adjacency.get(arr[1]).add(arr[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(inDegrees[i] ==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            numCourses--;
            for(int n:adjacency.get(node)){
                inDegrees[n]--;
                if(inDegrees[n]==0){
                    queue.offer(n);
                }
            }
        }
        if(numCourses==0){
            return true;
        } else {
            return false;
        }
    }
}
