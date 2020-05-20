package leetcode.List;

import java.util.Scanner;

public class Pro2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //任意一个链表为空，那么返回另外一个
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        //以l1链表为主
        ListNode pL1 = l1, pL2 = l2;
        while(pL1.next != null && pL2.next != null) {
            pL1.val += pL2.val;
            pL1 = pL1.next;
            pL2 = pL2.next;
        }
        pL1.val += pL2.val;

        if (pL2.next == null) {
            //进行链表l1的进位运算
            process(l1);
        } else {
            //把链表l2的尾部接到l1的尾部
            pL1.next = pL2.next;

            //进行链表l1 的进位运算
            process(l1);
        }

        return l1;
    }

    private void process(ListNode head) {
        ListNode p = head;
        while(p.next != null) {
            if (p.val >= 10) {
                p.next.val += p.val / 10;
                p.val = p.val % 10;
            }

            p = p.next;
        }

        if (p.val >= 10) {

            int num = p.val / 10;

            p.val = p.val % 10;

            ListNode addNode = new ListNode(num);

            p.next = addNode;
        }
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

        Pro2 pro = new Pro2();

        ListNode l1 = pro.creatList();

        ListNode l2 = pro.creatList();

        pro.printList(l1);
        pro.printList(l2);

        System.out.println("=================================");

        ListNode res = pro.addTwoNumbers(l1, l2);

        pro.printList(res);
    }
}
