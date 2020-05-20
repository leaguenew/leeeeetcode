package leetcode.List;

import java.util.Scanner;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};

public class Pro430 {


    public Node flatten(Node head) {
        if (null == head) {
            return null;
        }

        Node cur = head, next = head.next;
        while(cur != null) {

            if (cur.child == null) {
                cur = cur.next;
                continue;
            }

            next = cur.next;
            mergeChildIntoList(cur, cur.child, next);
            cur.child = null;
            cur = cur.next;
        }

        return head;
    }

    private void mergeChildIntoList(Node cur, Node child, Node next) {

        Node head = child, tail = child;
        while(tail.next != null) {
            tail = tail.next;
        }

        cur.next = head;
        head.prev = cur;
        tail.next = next;
        if (null != next) {
            next.prev = tail;
        }
    }

    /**
     * 尾插法生成链表
     * @return
     */
    public ListNode createList() {

        Scanner in = new Scanner(System.in);

        int value = in.nextInt();

        /**
         * 再链表处理不好解决的时候，就一定要想到使用多个指针
         */
        ListNode tail = null, header = null;

        while (value != -1){

            if (header == null) {
                header = new ListNode(value);
                tail = header;
                header.next = null;
            } else {
                ListNode nodeTmp = new ListNode(value);
                tail.next = nodeTmp;
                tail = nodeTmp;
                tail.next = null;
            }

            value = in.nextInt();
        }

        return header;
    }

    public void printList(ListNode node) {

        while(node!= null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        Pro1019 pro = new Pro1019();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        int[] a = pro.nextLargerNodes(node);

        for(int val : a) {
            System.out.println(val);
        }

    }
}
