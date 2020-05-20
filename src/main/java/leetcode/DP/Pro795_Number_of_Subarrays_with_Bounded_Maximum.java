package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * 1.定义：dp[i][j]为数组a[i-j]的最大值
 * 2.状态转移：dp[i][j] = max(dp[i][j-1], A[j])
 * 3.初始值：dp[i][i] = A[i]
 * 4.结果：统计 L <= dp[i][j] <= R 的个数
 * @author: niuliguo
 * @create: 2020-05-04 17:42
 **/
public class Pro795_Number_of_Subarrays_with_Bounded_Maximum {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {

        if (null == A || A.length == 0) {
            return 0;
        }

        int len = A.length;
        int[][] dp = new int[len][len];

        int cnt = 0;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = A[i];
                    if (L <= dp[i][j] && dp[i][j] <= R) {
                        cnt++;
                    }
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j - 1], A[j]);

                if (L <= dp[i][j] && dp[i][j] <= R) {
                    cnt++;
                }
                System.out.println("i = " + i + ", j = " + j + ", dp[i][j] = " + dp[i][j] );
            }
        }

        return cnt;
    }
}
