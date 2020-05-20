package leetcode.DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description: least frequent used cache
 * 解析：这道题跟Pro136_LRU_Cache类似，唯一多的一个就是记录每个key的频率freq，并在freq相同的情况下，与lru类似，因此需要一个维护freq对应头节点的map
 * 1.数据结构：ListNode, Map<key, ListNode>, Map<freq, ListNode>
 * 2.get操作：
 * 2.1 如果key不存在，那么返回-1
 * 2.2 如果key存在，将对应key的ListNode的freq加一得到freq1
 * 2.2.1 如果有相同的freq1，插入到freq1对应链表的头节点；
 * 2.2.2 如果没有相同的freq1，那么创建相应链表
 * 3.put操作：
 * 3.1 如果key已经存在，那么更新相应的value并将freq加一得到freq1，并将原有节点摘下，插入到freq1对应链表的头结点
 * 3.2 如果key不存在
 * 3.2.1 如果当前容量没有满，那么插入链表
 * 3.2.2 如果当前容量满了，那么淘汰最小freq的末尾节点，并将新节点插入链表
 * @author: niuliguo
 * @create: 2020-05-04 14:27
 **/
public class Pro460_LFU_Cache {

    class ListNode {
        public int key;
        public int value;
        public int freq;
        public ListNode pre;
        public ListNode next;
        public ListNode() {
        }
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
            this.pre = null;
            this.next = null;
        }
    }
    private Map<Integer, ListNode> key2node = new HashMap<>();
    private Map<Integer, ListNode> freq2head = new HashMap<>();
    private int capacity;

    public Pro460_LFU_Cache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!key2node.containsKey(key) || capacity == 0) {
            return -1;
        }

        ListNode node = key2node.get(key);
        node.freq += 1;

        //remove the node
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;

        //insert into list
        if (freq2head.containsKey(node.freq)) {
            ListNode head = freq2head.get(node.freq);
            next = head.next;
            head.next = node;
            next.pre = node;
            node.next = next;
            node.pre = head;
        } else {
            ListNode head = new ListNode();
            head.next = node;
            head.pre = node;
            node.next = head;
            node.pre = head;
            freq2head.put(node.freq, head);
        }

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (key2node.containsKey(key)) {
            ListNode node = key2node.get(key);
            node.value = value;
            node.freq += 1;

            //remove the node
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;

            //insert into list
            if (freq2head.containsKey(node.freq)) {
                ListNode head = freq2head.get(node.freq);
                next = head.next;
                head.next = node;
                next.pre = node;
                node.next = next;
                node.pre = head;
            } else {
                ListNode head = new ListNode();
                head.next = node;
                head.pre = node;
                node.next = head;
                node.pre = head;
                freq2head.put(node.freq, head);
            }

            return;
        }

        if (key2node.size() < capacity) {
            ListNode node = new ListNode(key, value);
            key2node.put(key, node);
            //insert into list
            if (freq2head.containsKey(node.freq)) {
                ListNode head = freq2head.get(node.freq);
                ListNode next = head.next;
                head.next = node;
                next.pre = node;
                node.next = next;
                node.pre = head;
            } else {
                ListNode head = new ListNode();
                head.next = node;
                head.pre = node;
                node.next = head;
                node.pre = head;
                freq2head.put(node.freq, head);
            }

            return;
        } else {
            ListNode node = new ListNode(key, value);
            key2node.put(key, node);
            //remove least freq node
            removeLeastFreqNode();

            //insert into list
            if (freq2head.containsKey(node.freq)) {
                ListNode head = freq2head.get(node.freq);
                ListNode next = head.next;
                head.next = node;
                next.pre = node;
                node.next = next;
                node.pre = head;
            } else {
                ListNode head = new ListNode();
                head.next = node;
                head.pre = node;
                node.next = head;
                node.pre = head;
                freq2head.put(node.freq, head);
            }

            return;
        }
    }

    private void removeLeastFreqNode() {

        //get the least freq list and remove the tail node
        Integer leastFreqKey = null;
        for(Integer key: freq2head.keySet()) {
            if (freq2head.get(key).next != freq2head.get(key)) {
                leastFreqKey = key;
                break;
            }
        }
        ListNode head = freq2head.get(leastFreqKey);
        ListNode node = head.pre;

        //remove the node
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;

        key2node.remove(node.key);
    }

    private void print() {
        for(Integer key: freq2head.keySet()) {
            ListNode head = freq2head.get(key);
            System.out.println("<===freq = " + key + "====>");
            ListNode node = head.next;
            while(node.key != head.key) {
                System.out.println("key = " + node.key + ",value = " + node.value + ", freq = " + node.freq);
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
//        Map<Integer,Integer> map = new HashMap<>();
//
//        map.put(2,2);
//        map.put(3,3);
//        map.put(6,6);
//        map.put(5,5);
//        map.put(4,4);
//        map.put(1,1);
//
//        for(Map.Entry<Integer, Integer> vo : map.entrySet()) {
//            System.out.println("key = " + vo.getKey() + ", value = " + vo.getValue());
//        }
//
//        for(Integer key: map.keySet()) {
//            System.out.println("key = " + key);
//            break;
//        }

        Pro460_LFU_Cache cache = new Pro460_LFU_Cache( 2 /* capacity (缓存容量) */ );


    }
}
