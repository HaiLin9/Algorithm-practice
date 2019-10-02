package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode60 {
    public static void main(String[] args){
        System.out.println(getPermutation(3,2));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> li = new LinkedList();
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=n;i++){
            li.add(i);
        }
        getPermutation(sb,k,li);
        return sb.toString();
    }

    public static void getPermutation(StringBuffer sb, int k, List<Integer> li){
        if(li.size()==1){
            sb.append(li.remove(0));
        } else if (li.size()>1) {
            int permuNum = fact(li.size()-1);
            if(k<=permuNum){
                sb.append(li.remove(0));
                getPermutation(sb,k, li);
            } else{
                int divid = k/permuNum;
                if(k % permuNum>0){
                    divid++;
                }
                sb.append(li.remove(divid-1));
                getPermutation(sb,k-permuNum*(divid-1),li);
            }
        }
    }

    public static int fact(int num) {
        int temp=1;
        int factorial=1;
        while(num>=temp) {
            factorial=factorial*temp;
            temp++;
        }
        return factorial;
    }
}
