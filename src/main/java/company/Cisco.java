package company;


/**
一个已排序的单向链表，请删除数值重复的节点，返回新链表。 例如：1->1->2->3->3->3->4->5 返回：1->2->3->4->5
 */



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Cisco {
    public ListNode deleteDuplicates(ListNode head) {

        if (null == head || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = cur.next;
        while(cur.next != null) {
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            if (next == null) {
                cur.next = null;
            } else {
                cur = next;
                next = cur.next;
            }
        }

        return head;
        // your code
    }


}

