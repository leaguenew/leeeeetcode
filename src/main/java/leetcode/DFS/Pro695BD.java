package leetcode.DFS;

/**
 * @program: risk-leecode-example
 * @description: 深搜 + 位置变更（遍历过的位置要把它值改变）
 * @author: niuliguo
 * @create: 2020-02-17 16:25
 **/
public class Pro695BD {

    private int m;
    private int n;
    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int areaOfIsland = getArea(grid, i, j);
                    max = Math.max(max, areaOfIsland);
                }
            }
        }

        return max;
    }

    private int getArea(int grid[][], int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + getArea(grid, i - 1, j) + getArea(grid, i + 1, j)
                    + getArea(grid, i, j - 1) + getArea(grid, i, j + 1);
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
