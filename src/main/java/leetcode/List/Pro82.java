package leetcode.List;

import java.util.Scanner;

public class Pro82 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(head.val - 1);

        ListNode pre, mid, tail;
        pre = newHead;
        pre.next = head;
        tail = head.next;
        mid = head;

        boolean repeat = false;
        while(tail != null) {
            if (mid.val == tail.val) {
                tail = tail.next;
                repeat = true;
                continue;
            }

            if (repeat) {
                pre.next = tail;
                mid = tail;
                tail = tail.next;
                repeat = false;
            } else {
                pre = pre.next;
                mid = mid.next;
                tail = tail.next;
            }
        }

        //对于所以都是重复字符的情况。
        if (mid.next != null) {
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

        Pro82 pro82 = new Pro82();

        ListNode node = pro82.creatList();

        pro82.printList(node);

        System.out.println("=================================");

        node = pro82.deleteDuplicates(node);

        pro82.printList(node);
    }
}
