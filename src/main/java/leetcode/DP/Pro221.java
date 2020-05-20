package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-11-30 16:43
 **/
public class Pro221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){

                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        if (dp[i - 1][j - 1] ==  0) {
                            dp[i][j] = 1;
                        } else {
                            int len = (int)Math.sqrt(dp[i - 1][j -  1]);
                            int h;
                            boolean flag = false;
                            for(h = 0; h <= len; h++) {
                                if (matrix[i][j - h] == '1' &&
                                    matrix[i - h][j] == '1') {
                                    continue;
                                } else {
                                    flag = true;
                                    break;
                                }
                            }
                            if (!flag) {
                                dp[i][j] = (len + 1) * (len + 1);
                            } else {
                                dp[i][j] = h * h;
                            }
                        }
                    }
                }
            }
        }

//        for(int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        int max = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.print(dp[i][j] + " ");
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
//            System.out.println();
        }

        return max;
    }

    public static void main(String[] args) {
        Pro221 pro = new Pro221();

        char[][] matrix = new char[][]{
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '0', '0', '0', '0'}
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };

        System.out.println(pro.maximalSquare(matrix));
    }
}
