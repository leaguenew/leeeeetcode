package leetcode.DP;

import java.util.Arrays;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-07-28 09:27
 **/
public class Pro1277_Count_Square_Submatrices_with_All_Ones {

    /**
     * 动态规划：自顶向下，自左向右
     * 1.子问题：大的矩阵一定跟小的有关系
     * 2.状态定义：dp[i][j], 以matrix[i][j]结尾的全1矩形的个数
     * 3.状态转移：dp[i][j] =
     * if matrix[i][j] == 0:
     *    dp[i][j] = 0;
     * else:
     *    if matrix[i-1][j-1] == 0:
     *        dp[i][j] = 1;
     *    else:
     *        len = dp[i-1][j-1];//说明子问题都是1的长度
     *        判断matrix[i-len，i][j-len, j]全1的宽度
     * 4.结果：sum(dp[0-m][0-n])
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        if (null == matrix || matrix.length == 0 ||  matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
//        Arrays.fill(dp, 0);
        int ret = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //matrix[i][j] == 0
                if (0 == matrix[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                //matrix[i][j] == 1
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (matrix[i - 1][j - 1] == 0) {
                    dp[i][j] = 1;
                } else {
                    int len = dp[i - 1][j - 1];
                    int res = 1;
                    int ii = i - 1, jj = j - 1;
                    while( (ii >=  i - len) && (jj >= j - len) && ii >= 0 && jj >= 0 ){
                        if (matrix[ii][j] == 1 && matrix[i][jj] == 1) {
                            res += 1;
                            ii--;
                            jj--;
                        } else {
                            break;
                        }
                    }

                    dp[i][j] = res;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]);
                ret += dp[i][j];
            }
//            System.out.println();
        }

        return ret;
    }

    public static void main(String[] args) {
        Pro1277_Count_Square_Submatrices_with_All_Ones  pro = new Pro1277_Count_Square_Submatrices_with_All_Ones();
        int[][] matrix = new int[][] {
                {0,1,1},
                {1,1,1},
                {1,1,1}
        };
        System.out.println(pro.countSquares(matrix));
    }
}
