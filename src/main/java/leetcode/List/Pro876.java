package leetcode.List;

import java.util.Scanner;

public class Pro876 {

    public ListNode middleNode(ListNode head) {

        if (null == head  || null == head.next) {
            return head;
        }

        int len = getLengthOfList(head);

        int step = len / 2;

        while(step-- > 0) {
            head = head.next;
        }

        return head;
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

        Pro876 pro = new Pro876();

        ListNode node = pro.createList();


        System.out.println("=================================");

        node = pro.middleNode(node);

        System.out.println(node.val);
    }
}
