package leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-09 10:29
 **/
public class PriorityQueueTest {

    public static class VO {
        private int score;
        private String name;

        public VO(int score, String name) {
            this.score = score;
            this.name = name;
        }

        public String toString() {
            return score + "-" + name;
        }
    }

    public static void main(String[] args) {
        /**
         * 小顶堆
         */
        Queue<Integer> queue1 = new PriorityQueue<Integer>();
        queue1.add(2);
        queue1.add(3);
        queue1.add(1);
        queue1.add(3);
        System.out.println(queue1.contains(3));
        System.out.println(queue1.contains(4));
        while(!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }

        /**
         * 大顶堆
         */
        Queue<Integer> queue2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue2.add(6);
        queue2.add(7);
        queue2.add(8);
        while(!queue2.isEmpty()) {
            System.out.println(queue2.poll());
        }

        /**
         * 对类中的参数进行排序
         */
        Comparator<VO> comparator = new Comparator<VO>() {
            public int compare(VO o1, VO o2) {
                return o1.score - o2.score; //小顶堆
//                return o2.score - o1.score; //大顶堆
            }
        };
        Queue<VO> queue3 = new PriorityQueue<VO>(comparator);
        queue3.add(new VO(10, "B"));
        queue3.add(new VO(5, "A"));
        queue3.add(new VO(15, "C"));
        while (!queue3.isEmpty()) {
            System.out.println(queue3.poll().toString());
        }
    }
}
