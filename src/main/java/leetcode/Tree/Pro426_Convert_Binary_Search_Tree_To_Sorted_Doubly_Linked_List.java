package leetcode.Tree;



/**
 * 经典
 * 两种算法：
 * 1、用个数组保存起来，然后形成链表
 * 2、原地执行
 * 左指针 -> 前序指针，右指针 -> 后续指针
 *
 */
public class Pro426_Convert_Binary_Search_Tree_To_Sorted_Doubly_Linked_List {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    private Node head = null;

    private Node preNode;

    private Node curNode;

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;

            return root;
        }

        inorderTraverse(root);

        head.left = curNode;
        curNode.right = head;

        return head;
    }

    private void inorderTraverse(Node root) {
        if (null == root) {
            return;
        }

        inorderTraverse(root.left);

        if (head == null) {
            head = root;
            preNode = root;
        } else {
            curNode = root;
            preNode.right = curNode;
            curNode.left = preNode;
            preNode = curNode;
        }

        inorderTraverse(root.right);
    }

    public static void main(String[] args) {
        String s1 = "小争哥";
        String s2 = "小争哥";
        String s3 = new String("小争哥");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }

}
