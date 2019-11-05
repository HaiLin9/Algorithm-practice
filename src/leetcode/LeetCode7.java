package leetcode;

/**
 * ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
 *
 * ʾ��?1:
 *
 * ����: 123
 * ���: 321
 * ?ʾ�� 2:
 *
 * ����: -123
 * ���: -321
 * ʾ�� 3:
 *
 * ����: 120
 * ���: 21
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-integer
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode7 {
    public int reverse(int x) {
        int result=0;
        int positive = 1;
        if(x<0){
            positive = -1;
            x = -x;
        }
        while(x>0){
            int val = x % 10;
            x/=10;
            result = result*10 + val;
        }
        if(result>=Integer.MAX_VALUE||result<=Integer.MIN_VALUE){
            return 0;
        }
        return result * positive;
    }
}
