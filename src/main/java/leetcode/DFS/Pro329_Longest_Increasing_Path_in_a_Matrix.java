package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-04-10 18:22
 **/
public class Pro329_Longest_Increasing_Path_in_a_Matrix {

    private int m, n;
    private int[][] arr;
    public int longestIncreasingPath(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return 0;
        }

        this.m = matrix.length;
        this.n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        arr = new int[m][n];

        int maxVal = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int maxTmp = dfs(visited, matrix, i, j, Integer.MIN_VALUE);
                arr[i][j] = maxTmp;
                maxVal = Math.max(maxVal, maxTmp);
                System.out.println("i = " + i + ", j = " + j + ", maxVal = " + maxVal + ", maxTmp = " + maxTmp);
            }
        }

        return maxVal;
    }

    /**
     * 方法定义：以matrix[i][j]开头的最长上升序列
     * @param visited
     * @param matrix
     * @param i
     * @param j
     * @param preVal
     * @return
     */
    private int dfs(boolean[][] visited, int[][] matrix, int i, int j, int preVal) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || preVal >= matrix[i][j]) {
            return 0;
        }

        /**
         * 记忆化递归剪枝
         */
        if (arr[i][j] != 0) {
            return arr[i][j];
        }


        visited[i][j] = true;
        int cnt = 1;

        int val0 = dfs(visited, matrix, i, j + 1, matrix[i][j]);
        int val1 = dfs(visited, matrix, i, j - 1, matrix[i][j]);
        int val2 = dfs(visited, matrix, i - 1, j, matrix[i][j]);
        int val3 = dfs(visited, matrix, i + 1, j, matrix[i][j]);

        visited[i][j] = false; //回溯

        arr[i][j] = cnt + Math.max(val0, Math.max(val1, Math.max(val2, val3)));//记忆化递归

        return  arr[i][j];
    }

    public static void main(String[] args) {
        Pro329_Longest_Increasing_Path_in_a_Matrix pro = new Pro329_Longest_Increasing_Path_in_a_Matrix();
//        int[][] matrix = new int[][]{
//                {9,9,4},
//                {6,6,8},
//                {2,1,1}
//        };

        int[][] matrix = new int[][]{
                {0,1,2,3,4,5,6,7,8,9},
                {19,18,17,16,15,14,13,12,11,10},
                {20,21,22,23,24,25,26,27,28,29},
                {39,38,37,36,35,34,33,32,31,30},
                {40,41,42,43,44,45,46,47,48,49},
                {59,58,57,56,55,54,53,52,51,50},
                {60,61,62,63,64,65,66,67,68,69},
                {79,78,77,76,75,74,73,72,71,70},
                {80,81,82,83,84,85,86,87,88,89},
                {99,98,97,96,95,94,93,92,91,90},
                {100,101,102,103,104,105,106,107,108,109},
                {119,118,117,116,115,114,113,112,111,110},
                {120,121,122,123,124,125,126,127,128,129},
                {139,138,137,136,135,134,133,132,131,130},
                {0,0,0,0,0,0,0,0,0,0}
        };

        System.out.println(pro.longestIncreasingPath(matrix));
    }
}
