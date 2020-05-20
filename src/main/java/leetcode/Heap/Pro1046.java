package leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pro1046 {

    Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public int lastStoneWeight(int[] stones) {
        if (null == stones || stones.length == 0) {
            return 0;
        }
        for(int i = 0 ;i < stones.length; i++) {
            queue.add(stones[i]);
        }
        while(queue.size() > 1) {
            int top = queue.poll();
            int peek = queue.poll();
            System.out.println("top = " + top + ", peek = " + peek);
            if(top == peek) {
                continue;
            }
            int diff = Math.abs(peek - top);
            queue.add(diff);
        }

        if (queue.size() == 0) {
            return 0;
        } else {
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        Pro1046 pro = new Pro1046();
        int[] nums = new int[]{2,7,4,1,8,1};
        System.out.println(pro.lastStoneWeight(nums));
    }
}
