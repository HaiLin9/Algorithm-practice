package leetcode;

import java.util.Arrays;

/**
 *ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
 *
 * �����������һ����������У��������������г���С�����У����������У���
 *
 * ����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 *
 * ������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
 * 1,2,3 �� 1,3,2
 * 3,2,1 �� 1,2,3
 * 1,1,5 �� 1,5,1
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/next-permutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0){
            return;
        }
        int cur = nums.length-1;
        while(cur>0){
            if(nums[cur] <= nums[cur-1]){
                cur--;
            } else {
                break;
            }
        }

        if(cur==0){
            Arrays.sort(nums);
            return;
        }

        int temp = nums[cur-1];
        int max = cur;
        for(int i=max;i<nums.length;i++){

        }

        }
    }
}
