package leetcode.List;

/**
 * 反转链表
 */
public class ProNC78 {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode post = head.next;

        while (post != null) {
            cur.next = pre;
            pre = cur;
            cur = post;
            post = post.next;
        }

        cur.next = pre;

        return cur;
    }
}
