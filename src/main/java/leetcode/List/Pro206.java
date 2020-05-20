package leetcode.List;

import java.util.Scanner;

public class Pro206 {

    public ListNode reverseList(ListNode head) {

        if (null == head || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode mid = head , tail = head.next;
        while(tail != null) {

            mid.next = pre;
            pre = mid;
            mid = tail;
            tail = tail.next;
        }

        mid.next = pre;

        return mid;
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

        Pro206 pro = new Pro206();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        node = pro.reverseList(node);

        pro.printList(node);
    }
}
