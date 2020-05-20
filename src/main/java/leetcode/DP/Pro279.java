package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 *
 * @author: niuliguo
 * @create: 2020-03-02 11:08
 **/
public class Pro279 {

    /**
     * dp[i]: 定义为形成数字i的最小的平方数的个数
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        for(int i = 0; i <= n; i++) {
            System.out.println("i = " + i + ",dp[i] = " + dp[i]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Pro279 pro = new Pro279();
        System.out.println(pro.numSquares(12));
    }
}
