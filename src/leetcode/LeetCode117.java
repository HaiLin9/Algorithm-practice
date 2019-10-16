package leetcode;

/**
 * ����һ��������
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * �������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
 *
 * ��ʼ״̬�£�����?next ָ�붼������Ϊ NULL��
 *
 * ?
 *
 * ʾ����
 *
 *
 *
 * ���룺{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * �����{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 *
 * ���ͣ�������������ͼ A ��ʾ����ĺ���Ӧ���������ÿ�� next ָ�룬��ָ������һ���Ҳ�ڵ㣬��ͼ B ��ʾ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }
        if(root.left != null) {
            if(root.right!=null){
                root.left.next=root.right;
            } else {
                if(root.next != null) {
                    if(root.next.left!=null){
                        root.left.next = root.next.left;
                    } else if(root.next.right!=null){
                        root.left.next = root.next.right;
                    }
                }
            }
        }

        if(root.right != null){
            if(root.next!=null){
                if(root.next.left!=null){
                    root.right.next = root.next.left;
                } else if(root.next.right!=null){
                    root.right.next = root.next.right;
                }
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
