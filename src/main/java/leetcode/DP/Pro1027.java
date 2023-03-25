package leetcode.DP;


/**
 * dp[i][j]: num[i..j]是不是等差数列， i <= j
 * 状态转移方程：见代码
 */
public class Pro1027 {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        for(int i = 0 ; i < n; i++) {
            for(int j = i; j < n; j++) {
                if (i == j || i + 1 == j) {
                    dp[i][j] = true;
                } else {
                    if (!dp[i][j - 1]) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2];
                    }
                }

                if (dp[i][j]) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
