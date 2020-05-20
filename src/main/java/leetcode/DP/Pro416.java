package leetcode.DP;

import java.util.Arrays;

/**
 * @program: risk-leecode-example
 * @description:
 * 定义问题：dp[i][j]: 前i个数中，是否存在和等于j
 * 状态转移方程：
 * dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
 * 初始化：dp[0][*] = dp[*][0] = false;
 * 结果：dp[0~len-2][sum/2] 是否有true的
 * @author: niuliguo
 * @create: 2020-03-17 17:42
 **/
public class Pro416 {

    public boolean canPartition(int[] nums) {
        if (null == nums || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        int len = nums.length;

        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for(int i = 0; i < len + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {

                /**
                 * bad case
                 */
                if ( i == 0 &&  j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if ( i == 0 || j == 0) {
                    dp[i][j] = false;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] || (j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] : false);
            }
        }

        for(int i = 0; i <= len; i++) {
            for(int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[len][sum];
    }

    public static void main(String[] args) {
        Pro416 pro = new Pro416();
        int[] nums = new int[]{1,2,5};
        System.out.println(pro.canPartition(nums));
    }
}
