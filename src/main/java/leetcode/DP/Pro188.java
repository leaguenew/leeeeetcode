package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description: https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%9B%A2%E7%81%AD%E8%82%A1%E7%A5%A8%E9%97%AE%E9%A2%98.md
 * 1.子问题：今天取得的最大利润，跟前一天的最大利润 + 今天的操作有关
 * 2.状态定义：子问题跟三个参数有关，a.操作天数；b.买卖的次数，c.今天是卖出，买入还是不操作(对应状态持有或不持有)；因此需要三个变量，
 * dp[i][k][s]：最大收益，1<=i<=n，1<=k<=K，s in {0（未持有），1（持有）}，
 * s = 0:没有买入未持有 || 当天卖出之后未持有   s = 1: 买入之后持有
 * 3.状态转移：
 * dp[i][k][0] = Math.max(dp[i - 1][k][0](昨天未持有 - 今天不操作 - 今天不持有), dp[i - 1][k][1] + price[i-1](昨天持有 -> 今天卖出 -> 今天未持有）);
 * dp[i][k][1] = Math.max(dp[i - 1][k - 1][0] - price[i - 1](昨天未持有 -> 今天买入 -> 今天持有), dp[i - 1][k][1](昨天持有 -> 今天不操作 -> 今天持有));
 * 注意：第二个方程里面的应该是k-1而不是k，因为每买入一次，就较少一次买入进入机会，或者说第k次买入后持有的的最大利润依赖于第k-1次的买入卖出状态
 * 4.边界问题：
 * dp[i][0][0] = 0 (买卖次数是0次，没有交易)，s = 0必然是0
 * dp[i][0][1] = Integer.MIN_VALUE (买卖次数是0次，持有情况下极小值)，s = 1状态不存在为极小值
 * dp[0][k][s] = 0 （交易天数为0，利润为0啊）
 * dp[1][k][0] = 0
 * dp[1][k][1] = -prices[0]
 * 5.结果：dp[n][K][0]在未持有的情况下的最大值
 * @author: niuliguo
 * @create: 2020-04-06 17:27
 **/
public class Pro188 {

    public int maxProfit(int k, int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int K = k;

        if (k > n / 2) {
            //k无限大的情况
            return maxProfitPro122(prices);
        }

        int[][][] dp = new int[n + 1][K + 1][2];
        for(int kk = 0; kk <= K; kk++) {
            for(int i = 0; i < n; i++) {
                if (kk == 0) {
                    dp[i][kk][0] = 0;
                    dp[i][kk][1] = Integer.MIN_VALUE;
                    continue;
                }

                /**
                 * 第一天，买入：利润：-prices[0]
                 * 第一天，不存在卖出，利润：0
                 */
                if (i == 0) {
                    dp[i][kk][0] = 0;
                    dp[i][kk][1] = -prices[0];
                    continue;
                }

                dp[i][kk][0] = Math.max(dp[i - 1][kk][0], dp[i - 1][kk][1] + prices[i]);
                // * 注意：第二个方程里面的应该是k-1而不是k，因为每买入一次，就较少一次买入进入机会，或者说第k次买入后持有的的最大利润依赖于第k-1次的买入卖出状态
                dp[i][kk][1] = Math.max(dp[i - 1][kk - 1][0] - prices[i], dp[i - 1][kk][1]);
//                System.out.println("dp[" + i + "][" + k + "][0] = " + dp[i][k][0]);
//                System.out.println("dp[" + i + "][" + k + "][1] = " + dp[i][k][1]);
            }
        }

        return dp[n - 1][K][0];
    }

    public int maxProfitPro122(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for(int i = 0; i < n; i++) {

            /**
             * 第一天，买入：利润：-prices[0]
             * 第一天，不存在卖出，利润：0
             */
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);

            System.out.println("dp[" + i + "][0] = " + dp[i][0]);
            System.out.println("dp[" + i + "][1] = " + dp[i][1]);
        }


        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        Pro188 pro = new Pro188();
//        int[] prices = new int[]{2,4,1};
        int[] prices = new int[]{3,2,6,5,0,3};
//        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(pro.maxProfit(2,prices));
    }
}
