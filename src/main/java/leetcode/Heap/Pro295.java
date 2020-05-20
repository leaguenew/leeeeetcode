package leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-11 16:42
 **/
public class Pro295 {

    /** initialize your data structure here. */
    //大顶堆: 存储较小元素
    private Queue<Integer> bigTopStack;
    //小顶堆：存储较大元素，保证bigTopStack.size() == smallTopStack.size() 或者
    //bigTopStack.size() + 1 == smallTopStack.size()
    private Queue<Integer> smallTopStack;

    //MedianFinder
    public Pro295() {
        bigTopStack = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        smallTopStack = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (bigTopStack.size() == smallTopStack.size()) {

            if (bigTopStack.size() == 0) {
                bigTopStack.add(num);
                return;
            }

            int peekSmallTop = smallTopStack.peek();
            if (num <= peekSmallTop) {
                bigTopStack.add(num);
            } else {
                smallTopStack.add(num);
                num = smallTopStack.poll();
                bigTopStack.add(num);
            }
        } else {
            int peekBigTop = bigTopStack.peek();
            if (num <= peekBigTop) {
                bigTopStack.add(num);
                peekBigTop = bigTopStack.poll();
                smallTopStack.add(peekBigTop);
            } else {
                smallTopStack.add(num);
            }
        }
    }

    public double findMedian() {
        if (bigTopStack.size() == smallTopStack.size()) {
            return (bigTopStack.peek() + smallTopStack.peek()) / 2.0;
        } else {
            return bigTopStack.peek();
        }
    }

    public static void main(String[] args) {
        System.out.println( ( 4 + 5) / 2.0);
    }
}
