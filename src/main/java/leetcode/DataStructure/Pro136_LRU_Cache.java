package leetcode.DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * 1.定义数据结构，双向链表，map，多出来一个头节点（减少并不必要的头结点的变化）
 * 2.get操作：
 * >如果不在，返回-1
 * >如果在，如果是head.next节点，无需操作；否则摘下来插入头结点。
 * 3.put操作：
 * >key是否存在，如果存在，那么更新value，并摘下来放到head.next节点；key不存在，分两种情况：
 * >>队列满了，那么把尾节点拿下来并从map中删除，然后把新结点插入头部，更新map
 * >>队列没有满：新结点插入头部，更新map
 * @author: niuliguo
 * @create: 2020-04-18 18:56
 **/
public class Pro136_LRU_Cache {

    class ListNode {
        public ListNode next;
        public ListNode pre;
        public int value;
        public int key;
        public ListNode() {

        }
    }

    private Map<Integer, ListNode> map = new HashMap<>();
    private int capacity;
    private ListNode head = null;
    public Pro136_LRU_Cache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);

        if (node == head.next) {
            return node.value;
        }

        //remove node
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;

        //insert node to the head.next;
        next = head.next;
        head.next = node;
        node.pre  = head;
        node.next = next;
        next.pre = node;

        return node.value;
    }

    public void put(int key, int value) {
        if (map.size() == capacity) {
            //key是否存在两种方案
            if (!map.containsKey(key)) {
                //remove tail
                ListNode tail = head.pre;
                ListNode pre = tail.pre;
                pre.next = head;
                head.pre = pre;
                map.remove(tail.key);

                //insert node to the head.next;
                ListNode node = new ListNode();
                node.value = value;
                node.key = key;
                ListNode next = head.next;
                head.next = node;
                node.pre  = head;
                node.next = next;
                next.pre = node;
                map.put(key, node);
            } else {
                //remove node
                ListNode node = map.get(key);
                node.value = value;
                ListNode pre = node.pre;
                ListNode next= node.next;
                pre.next = next;
                next.pre = pre;

                //insert node to the head.next;
                next = head.next;
                head.next = node;
                node.pre  = head;
                node.next = next;
                next.pre = node;
            }
        } else {
            if (map.containsKey(key)) {
                //remove node
                ListNode node = map.get(key);
                node.value = value;
                ListNode pre = node.pre;
                ListNode next= node.next;
                pre.next = next;
                next.pre = pre;

                //insert node to the head.next;
                next = head.next;
                head.next = node;
                node.pre  = head;
                node.next = next;
                next.pre = node;
            } else {
                ListNode node = new ListNode();
                node.value = value;
                node.key = key;
                map.put(key, node);
                if (head.next == null) {
                    head.next = node;
                    head.pre = node;
                    node.next = head;
                    node.pre = head;
                } else {
                    ListNode next = head.next;
                    head.next = node;
                    node.pre = head;
                    node.next = next;
                    next.pre = node;
                }
            }
        }
    }

    public void put1(int key, int value) {
        if (map.containsKey(key)) {
            //remove node
            ListNode node = map.get(key);
            node.value = value;
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;

            //insert node to the head.next;
            next = head.next;
            head.next = node;
            node.pre = head;
            node.next = next;
            next.pre = node;

            return;
        }

        if (map.size() == capacity) {
            //remove tail
            ListNode tail = head.pre;
            ListNode pre = tail.pre;
            pre.next = head;
            head.pre = pre;
            map.remove(tail.key);

            //insert node to the head.next;
            ListNode node = new ListNode();
            node.value = value;
            node.key = key;
            ListNode next = head.next;
            head.next = node;
            node.pre  = head;
            node.next = next;
            next.pre = node;
            map.put(key, node);
        } else {
            ListNode node = new ListNode();
            node.value = value;
            node.key = key;
            map.put(key, node);
            if (head.next == null) {
                head.next = node;
                head.pre = node;
                node.next = head;
                node.pre = head;
            } else {
                ListNode next = head.next;
                head.next = node;
                node.pre = head;
                node.next = next;
                next.pre = node;
            }
        }
    }

    public static void main(String[] args) {
        Pro136_LRU_Cache pro = new Pro136_LRU_Cache(2);
        pro.put1(2,1);
        pro.put1(1,1);
        pro.put1(2,3);
        pro.put1(4,1);
        System.out.println(pro.get(1));//-1
        System.out.println(pro.get(2));//3
    }
}
