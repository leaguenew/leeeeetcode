package leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-09 10:50
 **/
public class Pro264 {


    /**
     * 小顶堆
     */
    private Queue<Long> queue = new PriorityQueue<>();
    public int nthUglyNumber(int n) {

        if(n == 1) {
            return 1;
        }
        queue.add(1l);
        while(n > 1) {
            long top = queue.peek();
            if (!queue.contains((long)(top * 2))) {
                queue.add((long)(top * 2));
            }
            if (!queue.contains((long)(top * 3))) {
                queue.add((long)(top * 3));
            }
            if (!queue.contains((long)(top * 5))) {
                queue.add((long)(top * 5));
            }
            queue.poll();
            n--;
        }

        return queue.peek().intValue();
    }

    public static void main(String[] args) {
        Pro264 pro = new Pro264();
        System.out.println(pro.nthUglyNumber(1));
        System.out.println(pro.nthUglyNumber(2));
        System.out.println(pro.nthUglyNumber(3));
        System.out.println(pro.nthUglyNumber(4));
        System.out.println(pro.nthUglyNumber(5));
        System.out.println(pro.nthUglyNumber(10));
        System.out.println(pro.nthUglyNumber(1407)); //536870912
        System.out.println(pro.nthUglyNumber(1432)); //612220032
    }
}
