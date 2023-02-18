package leetcode.Array;

import java.util.*;

public class Pro414_thirdMax {

    public int thirdMax(int[] nums) {
        Queue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                //关键点在与这个条件，大bug
                if (o1 == Integer.MIN_VALUE) {
                    return 1;
                }
                if (o2 == Integer.MIN_VALUE) {
                    return -1;
                }
                return o2 - o1;
            }
        });
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(Integer item: set) {
            queue.add(item);
        }

        if (queue.size() < 3) {
            return queue.peek();
        }

        int size = 3, res = 0;
        while ( size-- > 0) {
            res = queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648,1,1};
//        int[] nums = new int[]{3,2,1};
        Pro414_thirdMax pro = new Pro414_thirdMax();
        System.out.println(pro.thirdMax(nums));
    }
}
