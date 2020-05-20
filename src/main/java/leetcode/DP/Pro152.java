package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * 1.状态转移：dp[n][2], 因为有正负号的原因，需要用给一个二维数组保持一个最大最小的状态
 * dp[i][0]: 最大乘积
 * dp[i][1]: 最小乘积
 * 2.状态转移：
 * dp[i][0] = Math.max( Math.max(dp[i - 1][0] * nums[i]) , dp[i - 1[1] * nums[i])) nums[i] )
 * dp[i][1] = Math.min( Math.min(dp[i - 1][0] * nums[i]) , dp[i - 1][1] * nums[i])), nums[i] )
 * 3.初始值：dp[0][0] = nums[0], dp[0][1] = nums[0];
 * 4.结果：dp[n-1][0]
 * @author: niuliguo
 * @create: 2020-03-20 16:01
 **/
public class Pro152 {

    public int maxProduct(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max( Math.max(dp[i - 1][0] * nums[i] , dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.min( Math.min(dp[i - 1][0] * nums[i] , dp[i - 1][1] * nums[i]), nums[i]);
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }

        return max;
    }
}
