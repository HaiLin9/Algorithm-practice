package leetcode;

import java.util.Arrays;

/**
 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
 *
 * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ�?���������������ĸ߶Ȳ�ľ���ֵ������ 1��
 *
 * ʾ��:
 *
 * ������������: [-10,-3,0,5,9],
 *
 * һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode108 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOf(nums,mid));
        int[] rightArr = new int[nums.length-mid-1];
        System.arraycopy(nums,mid+1,rightArr,0,nums.length-mid-1);
        root.right = sortedArrayToBST(rightArr);
        return root;
    }
}
