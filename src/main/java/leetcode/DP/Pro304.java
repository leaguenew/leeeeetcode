package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-12-07 11:57
 **/
public class Pro304 {

    private int[][] dp;

    public Pro304(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        /**
         * dp[row][col]定义为从左上角matrix[0][0]到右下角matrx[row - 1][col -1]的面积(1<=row<=m; 1<=col<=n)
         * 状态转移方程为：
         * dp[row + 1][col + 1] = dp[row][col + 1] + dp[row + 1][col] - dp[row][col] +  matrix[row + 1][col + 1]; (row >= 0 && col >= 0)
         * dp[row][col] = 0, (row = 0 || col = 0)
         * 处理row和col等于0的特殊情况即可
         */
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                dp[row + 1][col + 1] = dp[row][col + 1] + dp[row + 1][col] - dp[row][col] +  matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {


        return dp[row2 + 1][col2  + 1]  - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        Pro304 pro = new Pro304(matrix);
        System.out.println(pro.sumRegion(1, 2, 2, 4));
    }
}
