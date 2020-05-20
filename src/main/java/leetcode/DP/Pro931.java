package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * 动态规划，状态转移方程:
 * dp[i][j]到当前节点路径的最小值
 * dp[i + 1][j + 1] = min(dp[i][j], dp[i + 1][j], dp[i + 2][j]) + A[i][j]. (0<=i<=len-1, 0<=j<=len-1)
 * @author: niuliguo
 * @create: 2019-12-08 09:44
 **/
public class Pro931 {

    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = new int[n + 2][n + 2];
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if (c == 0) {
                    dp[r + 1][c + 1] = Math.min(dp[r][c + 1], dp[r][c + 2]) + A[r][c];
                } else if(c == n - 1) {
                    dp[r + 1][c + 1] = Math.min(dp[r][c], dp[r][c + 1]) + A[r][c];
                } else {
                    dp[r + 1][c + 1] = Math.min(dp[r][c], Math.min(dp[r][c + 1], dp[r][c + 2])) + A[r][c];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        printDp(dp);

        for(int i = 1; i <= n; i++) {
            if (dp[n][i] < min) {
                min = dp[n][i];
            }
        }

        return min;
    }

    private void printDp(int[][] dp) {
        int n = dp.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
//                {-19,57},
//                {-40,-5}
        };
        Pro931 pro = new Pro931();
        System.out.println(pro.minFallingPathSum(A));
    }
}
