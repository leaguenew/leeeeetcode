package leetcode.List;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-11 16:33
 **/
public class Pro23 {

    private Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    });
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        for(ListNode listNode: lists) {
            ListNode head = listNode;
            while(head != null) {
                queue.add(head);
                head = head.next;
            }
        }

        ListNode head = queue.poll();
        ListNode tail = head;
        while(queue.size() > 0) {
            ListNode tmp =  queue.poll();
            tail.next = tmp;
            tail = tmp;
        }
        tail.next = null;

        return head;
    }

    public static void main(String[] args) {

    }
}
