package leetcode.List;

import java.util.Scanner;

public class Pro1019 {

    public int[] nextLargerNodes(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new int[]{0};
        }

        int len = getLengthOfList(head);
        int[] arr = new int[len];

        ListNode cur = head, tail = cur;
        int i = 0;
        while (cur != null) {

            tail = cur.next;
            while (tail != null) {
                if (cur.val >= tail.val) {
                    tail = tail.next;
                } else {
                    arr[i] = tail.val;
                    i++;
                    break;
                }
            }
            if (tail == null) {
                arr[i] = 0;
                i++;
            }

            cur = cur.next;
        }

        return arr;
    }

    public int getLengthOfList(ListNode node) {
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

        Pro1019 pro = new Pro1019();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        int[] a = pro.nextLargerNodes(node);

        for(int val : a) {
            System.out.println(val);
        }

    }
}
