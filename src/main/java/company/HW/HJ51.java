package company.HW;

import java.util.Scanner;

public class HJ51 {

     static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            Node head = new Node(0);
            head.next = null;
            Node cur = head;
            for(int i = 0; i < n; i++) {
                int val = in.nextInt();
                Node tmp = new Node(val);
                tmp.next = null;
                cur.next = tmp;
                cur = tmp;
            }
            int k = in.nextInt();
            int diff = n - k + 1;
            cur = head;
            for(int i = 0; i < diff; i++) {
                cur = cur.next;
            }
            System.out.println(cur.val);
        }
    }
}
