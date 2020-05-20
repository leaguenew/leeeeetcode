package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-04-29 10:32
 **/
public class GenSheiXue {



    public static void main(String[] args) {
        /**
         * 大顶堆
         */
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,20,19,18,17,16,15,14,13,12,11};
        int n = 10;
        for(Integer Int : arr) {
            if (queue.size() < n) {
                queue.add(Int);
            } else {
                if (queue.contains(Int)) {
                    continue;
                }
                int peek = queue.peek();
                if (Int >= peek) {
                    continue;
                } else {
                    queue.poll();
                    queue.add(Int);
                }
            }
        }

        /**
         * print res
         */
        for(Integer Int : queue) {
            System.out.println(Int);
        }
    }
}
