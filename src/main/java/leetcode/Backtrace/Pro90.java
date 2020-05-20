package leetcode.Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description: Pro78类似
   https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 * @author: niuliguo
 * @create: 2020-03-04 18:25
 **/
public class Pro90 {

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        backtracing(new ArrayList<>(), nums, 0);

        return resList;
    }

    private void backtracing(List<Integer> tmpList, int[] nums, int start) {
        resList.add(new ArrayList<>(tmpList));

        for(int i = start; i < nums.length; i++) {
            //去重
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            tmpList.add(nums[i]);
            backtracing(tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
