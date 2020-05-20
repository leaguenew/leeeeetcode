package leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-23 11:01
 **/
public class Pro946 {

    private Stack<Integer> stack = new Stack<Integer>();
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int p1 = 0, p2 = 0;
        while (p1 < pushed.length && p2 < popped.length) {
            if (stack.isEmpty()) {
                while(pushed[p1] != popped[p2] && p1 < pushed.length) {
                    stack.add(pushed[p1]);
                    p1++;
                }
                p1++;
                p2++;
            } else {
                if (popped[p2] == stack.peek()) {
                    stack.pop();
                    p2++;
                } else {
                    while(p1 < pushed.length && pushed[p1] != popped[p2]) {
                        stack.add(pushed[p1]);
                        p1++;
                    }
                    p1++;
                    p2++;
                }
            }
        }//while
        while(!stack.isEmpty() && p2 < popped.length) {
            if (stack.peek() == popped[p2]) {
                stack.pop();
                p2++;
            } else {
                p2++;
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 优秀解答
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for(int p : pushed){
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Pro946 pro = new Pro946();
//        int[] pushed = new int[]{1,2,3,4,5};
        int[] pushed = new int[]{8,9,2,3,7,0,5,4,6,1};
//        int[] poped1 = new int[]{4,5,3,2,1};
//        int[] poped2 = new int[]{4,3,5,1,2};
        int[] poped2 = new int[]{6,8,2,1,3,9,0,7,4,5};

//        System.out.println(pro.validateStackSequences(pushed, poped1));
        System.out.println(pro.validateStackSequences(pushed, poped2));
    }
}
