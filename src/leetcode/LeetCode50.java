package leetcode;

/**
 *ʵ��?pow(x, n)?�������� x �� n ���ݺ�����
 *
 * ʾ�� 1:
 *
 * ����: 2.00000, 10
 * ���: 1024.00000
 * ʾ��?2:
 *
 * ����: 2.10000, 3
 * ���: 9.26100
 * ʾ��?3:
 *
 * ����: 2.00000, -2
 * ���: 0.25000
 * ����: 2-2 = 1/22 = 1/4 = 0.25
 * ˵��:
 *
 * -100.0 <?x?< 100.0
 * n?�� 32 λ�з�������������ֵ��Χ��?[?231,?231?? 1] ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/powx-n
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode50 {
    public static void main(String[] args){
        myPow(2.0,10);
    }
    public static double myPow(double x, int n) {
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        double ans = 1;
        for(int i = 1; i<=n ;i++){
            ans = ans * x;
        }
        return ans;
    }
}
