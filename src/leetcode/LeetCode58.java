package leetcode;

/**
 * ����һ����������Сд��ĸ�Ϳո�?' '?���ַ��������������һ�����ʵĳ��ȡ�
 *
 * ������������һ�����ʣ��뷵�� 0?��
 *
 * ˵����һ��������ָ����ĸ��ɣ����������κοո���ַ�����
 *
 * ʾ��:
 *
 * ����: "Hello World"
 * ���: 5
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/length-of-last-word
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int length =0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}
