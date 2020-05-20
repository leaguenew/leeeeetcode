package leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pro719 {

    Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public int smallestDistancePair(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (queue.size() < k) {
                    queue.add(Math.abs(nums[i] - nums[j]));
                } else {
                    int dist = Math.abs(nums[i] - nums[j]);
                    if (dist < queue.peek()) {
                        queue.poll();
                        queue.add(dist);
                    }
                }
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        Pro719 pro = new Pro719();
        int[] nums = new int[]{1,3,1,2,1,9,2,6};
        int k = 30;
        System.out.println(pro.smallestDistancePair(nums, k));
    }
}
