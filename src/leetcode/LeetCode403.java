package leetcode;

/**
 *
 */
public class LeetCode403 {
    public static void main(String[] args){
        int[] arr= {0,1,3,6,10,15,16,21};
        System.out.println(canCross(arr));
    }

    public static boolean canCross(int[] stones) {
        if(stones==null || stones.length == 0){
            return false;
        }
        boolean[] canCross = new boolean[stones.length];
        canCross[0]  =true;
        canCross(stones,canCross,1,0);
        return canCross[stones.length-1];
    }

    public static void canCross(int[] stones, boolean[] canCross, int k, int index){
        if(index == 0){
            if(stones.length > 1 && stones[1]-stones[0]<=1){
                canCross[1] = true;
                canCross(stones, canCross, 1, 1);
            }
        } else{
            int next = index+1;
            while(next < stones.length ){
                if(stones[next] - stones[index] <=k+1 && stones[next] - stones[index]>=k-1){
                    canCross[next] = true;
                    canCross(stones, canCross, stones[next]-stones[index], next);
                }
                next++;
            }
        }
    }
}
