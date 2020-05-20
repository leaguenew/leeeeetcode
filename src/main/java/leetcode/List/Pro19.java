package leetcode.List;

import leetcode.List.ListNode;

public class Pro19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || n <= 0) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode pre, mid, tail;

        pre = newHead;
        pre.next = head;
        mid = head;
        tail = pre;

        while(n > 0 && tail != null) {
            tail = tail.next;
            n--;
        }

        //说明n的长度大于链表的长度，那么删除第一个
        if (tail == null) {
            newHead.next = newHead.next.next;

            return newHead.next;
        }

        while(tail.next != null) {
            pre = pre.next;
            mid = mid.next;
            tail = tail.next;
        }

        pre.next = mid.next;

        return newHead.next;
    }

}
