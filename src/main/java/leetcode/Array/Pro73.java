package leetcode.Array;

import java.util.Arrays;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-05 19:05
 **/
public class Pro73 {

    /**
     * 新开数组记录需要刷新刷新的行和列的位置
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] arrRow = new int[m];
        int[] arrCol = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 ) {
                    arrRow[i] = 1;
                    arrCol[j] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            if (arrRow[i] == 1) {
                for(int col = 0; col < n; col++) {
                    matrix[i][col] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if (arrCol[i] == 1) {
                for(int row = 0; row < m; row++) {
                    matrix[row][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
