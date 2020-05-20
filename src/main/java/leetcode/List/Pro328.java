package leetcode.List;

import java.util.Scanner;

public class Pro328 {

    public ListNode oddEvenList(ListNode head) {

        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }

        ListNode tail = getTailOfList(head);

        ListNode pre = head, mid = head.next, next = head.next.next, end = tail;

        while (next != null && end != mid && end != pre) {
            pre.next = next;
            tail.next = mid;
            mid.next = null;
            tail = mid;

            pre = pre.next;
            mid = pre.next;
            next = mid.next;
        }

        if (end == mid) {
            pre.next = next;
            tail.next = mid;
            mid.next = null;
        }

        return head;
    }

    private ListNode getTailOfList(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }

        return node;
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

        Pro328 pro = new Pro328();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        node = pro.oddEvenList(node);

        pro.printList(node);
    }
}
