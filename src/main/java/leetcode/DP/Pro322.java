package leetcode.DP;

import java.util.Arrays;

/**
 * @program: risk-leecode-example
 * @description: https://github.com/azl397985856/leetcode/blob/master/problems/322.coin-change.md
 * @author: niuliguo
 * @create: 2020-02-04 19:56

 **/
public class Pro322 {

    /**
     * 思路错误
     * 问题定义：dp[row][col] : 用i个硬币组成j元钱所需要的最小的个数
     * 转移方程：dp[row][col] = min(dp[row - 1][col], for k in coins: (dp[row - 1][col - coin[k]] + 1) )
     * 边界：dp[0][*] = maxValue, dp[*][0] = maxValue
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        if (null == coins || coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for(int row = 0; row <= len; row++) {
            for(int col = 0; col <= amount; col++) {
                if (row == 0 || col == 0) {
                    dp[row][col] = Integer.MAX_VALUE;
                    continue;
                }
                if (row == 1) {
                    int idx = Arrays.binarySearch(coins, col);
                    if (idx < 0) {
                        dp[row][col] = Integer.MAX_VALUE;
                    } else {
                        dp[row][col] = row;
                    }
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for(int i = 0; i < len; i++) {
                    if (coins[i] >= col) {
                        continue;
                    }
                    min = Math.min(min, dp[row - 1][col - coins[i]] == Integer.MAX_VALUE  ? Integer.MAX_VALUE : dp[row - 1][col - coins[i]]+ 1);
                }
                min = Math.min(min, dp[row - 1][col]);
                dp[row][col] = min;
            }
        }
        for(int row = 0; row <= len; row++) {
            for(int col = 0; col <= amount; col++) {
                System.out.print(dp[row][col] + " ");
            }
            System.out.println();
        }


        return dp[len][amount] == Integer.MAX_VALUE ? -1 : dp[len][amount];
    }

    /**
     * @description: https://github.com/azl397985856/leetcode/blob/master/problems/322.coin-change.md
     * 定义dp[i]: 组成i元钱需要的最小的硬币数
     * 状态转移：dp[i] = min(dp[i - 1], for k in coin: dp[i - coin[k]] + 1)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if (null == coins || coins.length == 0) {
            return 0;
        }

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    min = Math.min(dp[i - coins[j]] == Integer.MAX_VALUE ?  Integer.MAX_VALUE : dp[i - coins[j]] + 1, min);
                }
            }
            dp[i] = min;
        }

        for(int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return dp[amount] == Integer.MAX_VALUE ?  -1 :  dp[amount] ;
    }

    public static void main(String[] args) {
        Pro322 pro = new Pro322();
        int[] coins = new int[]{2,3,5};
//        int[] coins = new int[]{1,3};
        int amount = 7;
        System.out.println(pro.coinChange1(coins, amount));
    }
}
