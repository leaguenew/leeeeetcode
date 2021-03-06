package leetcode.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-07-04 16:43
 **/
public class Pro542_01_Matrix {


    /**
     * BFS：这道题的bug点在于以0初始队列条件
     * 1.将matrix值为0的坐标点加入到队列中
     * 2.出队入队
     * @return
     */

    class Point {
        public int row;
        public int col;

        public Point(int row, int col)  {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return new int[0][0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
//        Arrays.fill(visited, false);
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)  {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                }
            }
        }

        int[][]  dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int row = point.row;
            int col = point.col;

            for(int i = 0; i < dirs.length; i++) {
                int newRow = row + dirs[i][0];
                int newCol = col + dirs[i][1];

                if (newRow < 0 || newRow >= m  || newCol < 0 || newCol >= n || visited[newRow][newCol])  {
                    continue;
                }

                visited[newRow][newCol] = true;
                matrix[newRow][newCol] = matrix[row][col] + 1;
                queue.add(new Point(newRow, newCol));
            }
        }

        return matrix;
    }

    /**
     * 1.DFS，没啥可说的就是dfs，dfs的时候要记得回溯
     * @param matrix
     * @return
     */
    public int[][] updateMatrix1(int[][] matrix) {
        return null;
    }

    /**
     * 1.DP
     * @param matrix
     * @return
     */
    public int[][] updateMatrix2(int[][] matrix) {
        return new int[0][0];
    }

    public static void main(String[] args) {
        Pro542_01_Matrix pro = new Pro542_01_Matrix();
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println(pro.updateMatrix(matrix));

        System.out.println(Integer.MAX_VALUE + 1);
    }
}
