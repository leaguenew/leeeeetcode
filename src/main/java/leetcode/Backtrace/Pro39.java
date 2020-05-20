package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-06 17:48
 **/
public class Pro39 {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (null == candidates || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        List<Integer> left = new ArrayList<Integer>();
        for(Integer Int: candidates) {
            left.add(Int);
        }
        backtracing(new ArrayList<Integer>(), left, target);

        return res;
    }

    private void backtracing(List<Integer> cur, List<Integer> left, int target) {

        int sum = sumFun(cur);
        //求和相等，且单调增
        if (sum == target && increase(cur)) {

            res.add(cur);
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

    private boolean increase(List<Integer> list) {
        for(int i = 0; i  < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }

        return true;
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
        Pro39 pro = new Pro39();
//        int[] nums = new int[]{2,3,6,7};
//        int target = 7;
        int[] nums = new int[]{2,3,5};
        int target = 8;

        System.out.println(pro.combinationSum(nums, target));
    }
}
