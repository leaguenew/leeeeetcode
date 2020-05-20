package leetcode.List;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Pro83 {

    public ListNode node = null;

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        ListNode tail = cur.next;

        while(tail != null) {

            if (cur.val == tail.val) {
                tail = tail.next;
                continue;
            }

            cur.next = tail;
            cur = tail;
        }

        cur.next = null;

        return head;
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

        Pro83 pro83 = new Pro83();

        ListNode node = pro83.creatList();

//        pro83.printList(node);

        node = pro83.deleteDuplicates(node);

        pro83.printList(node);
    }
}
