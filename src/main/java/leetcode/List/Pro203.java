package leetcode.List;

import java.util.Scanner;

public class Pro203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        if (head.next == null && head.val == val) {
            return null;
        }

        ListNode newHead = new ListNode(val - 1);
        ListNode pre, mid, tail;

        pre = newHead;
        mid = head;
        pre.next = mid;
        tail = mid.next;

        while (tail != null) {

            if (mid.val == val) {
                mid = mid.next;
                tail = tail.next;
                pre.next = mid;
            } else {
                pre = pre.next;
                mid = mid.next;
                tail = tail.next;
            }
        }

        if (mid.val == val) {
            pre.next = tail;
        }

        return newHead.next;
    }

    /**
     * 尾插法生成链表
     * @return
     */
    public ListNode creatList() {

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

        Pro203 pro203 = new Pro203();

        ListNode node = pro203.creatList();

        pro203.printList(node);

        System.out.println("=================================");

        node = pro203.removeElements(node, 6);

        pro203.printList(node);
    }
}
