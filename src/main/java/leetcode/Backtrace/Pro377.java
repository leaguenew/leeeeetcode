package leetcode.Backtrace;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-07 11:26
 **/
public class Pro377 {

    private int res = 0;
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        backtracing(new ArrayList<Integer>(), list, target);

        return res;
    }

    public void backtracing(List<Integer> cur, List<Integer> left, int target) {
        int sum = sumFun(cur);
        if (sum == target) {
            res++;
            return;
        }
        if (sum > target) {
            return;
        }

        for(int i = 0; i < left.size(); i++) {
            List<Integer> curTemp = new ArrayList<Integer>(cur);
            curTemp.add(left.get(i));
            backtracing(curTemp, left, target);
        }
    }

    private int sumFun(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        int sum = 0;
        for(Integer Int: list) {
            sum += Int;
        }

        return sum;
    }


    public static void main(String[] args) {
        Pro377 pro = new Pro377();
//        int[] nums = new int[]{10,1,2,7,6,1,5};
        int[] nums = new int[]{1,2,3};
        int target = 4;
        System.out.println(pro.combinationSum4(nums, target));
    }
}
