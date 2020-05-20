package leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: risk-leecode-example
 * @description: 类似Pro674
 * @author: niuliguo
 * @create: 2020-02-18 18:20
 **/
public class Pro128BD {

    public int longestConsecutive(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            } else if (nums[i] == nums[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * hash table 和 线性空间构造
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) { //剪枝
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {

    }
}
