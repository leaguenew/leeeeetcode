package leetcode.List;

import java.util.Scanner;

public class Pro61 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = getLengthOfList(head);

        if (k > len) {
            k = k % len;
        }
        if (k == len || k == 0) {
            return head;
        }

        ListNode head1 = head, tail1 = head, head2, tail2;
        int diff = len - k - 1;
        while(diff > 0) {
            tail1 = tail1.next;
            diff--;
        }

        head2 = tail1.next;
        tail1.next = null;

        head2 = combineTwoList(head2, head1);

        return head2;
    }

    private ListNode combineTwoList(ListNode l1, ListNode l2) {
        ListNode head = l1;
        while(head.next != null) {
            head = head.next;
        }

        head.next = l2;

        return l1;
    }


    private int getLengthOfList(ListNode node) {
        int i = 0;
        while(node != null) {
            i++;
            node = node.next;
        }

        return i;
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

        Pro61 pro = new Pro61();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        node = pro.rotateRight(node, 3);

        pro.printList(node);
    }
}
