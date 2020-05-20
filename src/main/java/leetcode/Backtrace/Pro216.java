package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-04 19:22
 **/
public class Pro216 {

    private int k, n;
    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        this.k = k;
        this.n = n;

        int[] nums = new int[9];
        for(int i = 0; i < 9; i++) {
            nums[i] = i + 1;
        }

        backtracing(new ArrayList<>(), nums, 0);

        return resList;
    }

    private void backtracing(List<Integer> tmpList, int[] nums, int start) {

        if (tmpList.size() == k) {
            int sum = sumFunc(tmpList);
            if (sum == n) {
                resList.add(new ArrayList<>(tmpList));
            } else if (sum > n) {
                return;
            }
        } else if (tmpList.size() > k) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backtracing(tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    private int sumFunc(List<Integer> list) {
        int sum =  0;
        for(Integer Int: list) {
            sum += Int;
        }

        return sum;
    }

    public List<List<Integer>> combinationSum31(int k, int n) {

        this.n = n;

        backtracing1(new ArrayList<>(), 0, k, n);

        return resList;
    }

    private void backtracing1(List<Integer> tmpList, int start, int cntLeft, int sumLeft) {
        if (cntLeft == 0 && sumLeft == 0) {
            resList.add(new ArrayList<>(tmpList));
            return;
        }

        if (cntLeft < 0 || sumLeft < 0) {
            return;
        }

        for(int i = start; i <= 9; i++) {
            tmpList.add(i);
            backtracing1(tmpList, start + 1, cntLeft - 1, sumLeft - i);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
