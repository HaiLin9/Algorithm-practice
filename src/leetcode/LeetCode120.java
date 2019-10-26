package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
 *
 * ���磬���������Σ�
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * �Զ����µ���С·����Ϊ?11������2?+?3?+?5?+?1?= 11����
 *
 * ˵����
 *
 * ��������ֻʹ�� O(n)?�Ķ���ռ䣨n Ϊ�����ε��������������������⣬��ô����㷨��ܼӷ֡�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/triangle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        if(dp.length==0){
            return 0;
        }
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++){
            for(int j =0; j<=i; j++){
                if(j>0&&j<i){
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                } else if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
            }
        }
        Arrays.sort(dp[dp.length-1]);
        return dp[dp.length-1][0];
    }
}
