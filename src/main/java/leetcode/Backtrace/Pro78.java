package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description: 求所有组合（1，2.。。n位）
 https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 * @author: niuliguo
 * @create: 2020-03-04 17:59
 **/
public class Pro78 {

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {


        backtracing(new ArrayList<>(), nums, 0);

        return resList;
    }

    private void backtracing(List<Integer> tmpList, int[] nums, int start) {
        resList.add(new ArrayList<>(tmpList));

        for(int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backtracing(tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
