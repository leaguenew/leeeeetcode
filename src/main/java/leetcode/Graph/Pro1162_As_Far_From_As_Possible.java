package leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-07-19 20:38
 **/
public class Pro1162_As_Far_From_As_Possible {

    /**
     * BFS:类Pro542
     * @param
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
    public int maxDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        boolean allZero = true;
        int oneCnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)  {
                if (grid[i][j] == 1) {
                    allZero  = false;
                    grid[i][j] = 0; //跟Pro542的区别，置零
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                    oneCnt++;
                }
            }
        }

        if (allZero || oneCnt == m * n) {
            return -1;
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
                grid[newRow][newCol] = grid[row][col] + 1;
                queue.add(new Point(newRow, newCol));
            }
        }

        int max = -1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)  {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Pro1162_As_Far_From_As_Possible pro = new Pro1162_As_Far_From_As_Possible();
        int[][]  grid = new int[][]{
                {1, 0 ,0},
                {0, 0 ,0},
                {0, 0 ,0},
        };

        System.out.println(pro.maxDistance(grid));
    }
}
