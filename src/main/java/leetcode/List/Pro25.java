package leetcode.List;

import java.util.Scanner;

public class Pro25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }

        int length = getLengthOfList(head);
        if (k > length) {
            return head;
        }

        //init p1~p4
        ListNode headNew = new ListNode(-1);
        headNew.next = head;
        ListNode p1, p2, p3, p4 = null;
        p1 = headNew;
        p2 = head;
        p3 = p2;
        int kTmp = k - 1;
        while (kTmp > 0 && p3 != null) {
            p3 = p3.next;
            kTmp--;
        }
        if (kTmp == 0) {
            p4 = p3.next;
            p3.next = null;
        }

        if (null == p3) {
            return head;
        }

        while(p2 != null && p3 != null) {

            p2 = reverseList(p2);
            p3 = endPointOfList(p2);
            p1.next = p2;
            p3.next = p4;
            p1 = p3;
            p2 = p4;

            if (p2 == null) {
                p3 = null;
                p4 = null;
            } else {
                kTmp = k;
                while (kTmp > 0 && p3 != null) {
                    p3 = p3.next;
                    kTmp--;
                }
                if (kTmp == 0) {
                    if (null == p3) {
                        break;
                    }
                    p4 = p3.next;
                    p3.next = null;
                }

                if (null == p3) {
                    break;
                }
            }
        }

        return headNew.next;
    }

    public int getLengthOfList(ListNode node) {
        int i = 0;
        while(node != null) {
            i++;
            node = node.next;
        }

        return i;
    }

    private ListNode endPointOfList(ListNode node) {
        if (null == node) {
            return null;
        }

        while (node.next != null) {
            node = node.next;
        }

        return node;
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

        Pro25 pro = new Pro25();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        node = pro.reverseKGroup(node, 2);

        pro.printList(node);
    }
}

