package leetcode.List;

import java.util.Scanner;

public class Pro92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //根据m和n将链表拆分成3段
        if (null == head || null == head.next) {
            return head;
        }

        ListNode head1 = null, tail1 = null,  head2 = null,  tail2 = null,  head3 = null;
        if (m == 1) {
            head2 = head;
            tail2 = head;

            int diff = n - m;
            while(diff-- > 0) {
                tail2 = tail2.next;
            }

            if (tail2.next == null) {
                head3 = null;
            } else {
                head3 = tail2.next;
            }

            tail2.next = null;
            head2 = reverseList(head2);
            head2 = combineTwoList(head2, head3);

            return head2;
        } else {
            head1 = head;
            tail1= head;
            int m1 = m - 2;
            while(m1-- > 0) {
                tail1 = tail1.next;
            }

            head2 = tail1.next;
            tail2 = head2;

            int diff = n - m;
            while(diff-- > 0) {
                tail2 = tail2.next;
            }

            if (tail2.next == null) {
                head3 = null;
            } else {
                head3 = tail2.next;
            }

            tail2.next = null;
            head2 = reverseList(head2);
            head2 = combineTwoList(head2, head3);

            tail1.next = head2;

            return head1;
        }
    }

    private ListNode combineTwoList(ListNode l1, ListNode l2) {
        ListNode head = l1;
        while(head.next != null) {
            head = head.next;
        }

        head.next = l2;

        return l1;
    }

    private ListNode reverseList(ListNode head) {

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

        Pro92 pro = new Pro92();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        node = pro.reverseBetween(node, 1, 5);

        pro.printList(node);
    }
}
