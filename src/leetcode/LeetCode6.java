package leetcode;

/**
 * ��һ�������ַ������ݸ������������Դ������¡������ҽ���?Z �������С�
 *
 * ���������ַ���Ϊ "LEETCODEISHIRING"?����Ϊ 3 ʱ���������£�
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
 *
 * ����ʵ��������ַ�������ָ�������任�ĺ�����
 *
 * string convert(string s, int numRows);
 * ʾ��?1:
 *
 * ����: s = "LEETCODEISHIRING", numRows = 3
 * ���: "LCIRETOESIIGEDHN"
 * ʾ��?2:
 *
 * ����: s = "LEETCODEISHIRING", numRows =?4
 * ���:?"LDREOEIIECIHNTSG"
 * ����:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/zigzag-conversion
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode6 {
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0 || numRows==0){
            return "";
        }

        StringBuffer[] sbs = new StringBuffer[numRows];
        for(int i=0; i<numRows ;i++){
            sbs[i] = new StringBuffer();
        }

        int index = 0;
        boolean flag = true;
        for(int i = 0; i<s.length() ;i++){
            if(index==0){
                flag = true;
                sbs[0].append(s.charAt(i));
                index = index==numRows-1 ? 0:index+1;
            } else if(index==numRows-1){
                flag = false;
                sbs[index].append(s.charAt(i));
                index--;
            } else{
                if(flag){
                    sbs[index].append(s.charAt(i));
                    index++;
                } else{
                    sbs[index].append(s.charAt(i));
                    index--;
                }
            }
        }

        for(int i=1; i<numRows ;i++){
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
