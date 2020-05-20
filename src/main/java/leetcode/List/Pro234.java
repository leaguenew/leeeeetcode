package leetcode.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pro234 {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {

            return true;
        }

        ListNode headNew = head;
        int n = 0;
        while (headNew != null) {
            n++;
            headNew = headNew.next;
        }

        n = (n + 1) / 2;
        headNew = head;
        while (n-- > 0) {
            headNew = headNew.next;
        }

        headNew = reverseList(headNew);

        boolean flag = false;

        while(head != null && headNew != null) {
            if (head.val == headNew.val) {

                head = head.next;
                headNew = headNew.next;
                continue;
            } else {
                break;
            }
        }

        if (headNew == null) {
            flag = true;
        }

        return flag;
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

    public boolean isPalindrome1(ListNode head) {

        if (head == null || head.next == null) {

            return true;
        }

        List<Integer> arr = new ArrayList();
        ListNode headNew = head;
        while(headNew != null) {
            arr.add(headNew.val);
            headNew = headNew.next;
        }

        int length = arr.size();
        boolean flag = false;
        int i;
        for(i = 0; i < length / 2; i++) {
            if (arr.get(i).intValue() == arr.get(length - 1 - i).intValue()) {
                continue;
            } else {
                break;
            }
        }

        if (i == length / 2 ) {
            flag = true;
        }

        return flag;

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

        Pro234 pro = new Pro234();

        ListNode node = pro.createList();

        pro.printList(node);

        System.out.println("=================================");

        boolean flag = pro.isPalindrome(node);

        System.out.println(flag);
    }
}
