package leetcode.List;

import java.util.Scanner;

public class Pro24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode headNew = new ListNode(-1);
        headNew.next = head;
        ListNode p1, p2, p3, p4;
        p1 = headNew;
        p2 = head;
        p3 = head.next;
        p4 = p3.next;

        while (p2 != null && p3 != null) {

            p3.next = p2;
            p1.next = p3;
            p2.next = p4;

            p1 = p2;
            p2 = p4;
            if (p2 == null) {
                p3 = null;
                p4 = null;
            } else {
                p3 = p2.next;
                if (p3 == null) {
                    p4 = null;
                } else {
                    p4 = p3.next;
                }
            }
        }

        return headNew.next;
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

        Pro24 pro = new Pro24();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        node = pro.swapPairs(node);

        pro.printList(node);
    }
}
