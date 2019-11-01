package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *����һ��δ������������飬�ҳ���������еĳ��ȡ�
 *
 * Ҫ���㷨��ʱ�临�Ӷ�Ϊ?O(n)��
 *
 * ʾ��:
 *
 * ����:?[100, 4, 200, 1, 3, 2]
 * ���: 4
 * ����: ����������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-consecutive-sequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length==0){
            return  0;
        }
        Set<Integer> temp = new HashSet<>();
        for(int num : nums){
            temp.add(num);
        }
        int max =1;
        for(int num : nums){
            if(!temp.contains(num-1)){
               int count = 1;
               while(temp.contains(++num)){
                   count++;
               }
               max = Math.max(max,count);
            }
        }
        return max;
    }
}
