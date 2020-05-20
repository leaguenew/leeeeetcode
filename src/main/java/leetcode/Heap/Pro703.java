package leetcode.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-10 23:04
 **/
public class Pro703 {

    private Queue<Integer> queue = new PriorityQueue<>();
    private int k ;
    public Pro703(int k, int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        this.k = k;

        for(int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int left = queue.size() - k;
        while(left > 0) {
            queue.poll();
            left--;
        }
    }

    public int add(int val) {

        if (queue.size() == 0) {
            return 0;
        }

        if (queue.size() < k) {
            queue.add(val);
            return queue.peek();
        }

        int peek = queue.peek();
        if (val > peek) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }

    public static void main(String[] args) {

        int k = 3;
        int[] arr =  new int[]{4,5,8,2};
        Pro703 pro = new Pro703(k,arr);
        System.out.println(pro.add(3));// returns 4
        System.out.println(pro.add(5));// returns 5
        System.out.println(pro.add(10));// returns 5
        System.out.println(pro.add(9));// returns 8
        System.out.println(pro.add(4));// returns 8
    }
}
