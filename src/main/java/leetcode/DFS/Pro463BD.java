package leetcode.DFS;

/**
 * @program: risk-leecode-example
 * @description: Pro695变形题
 * @author: niuliguo
 * @create: 2020-02-18 10:33
 **/
public class Pro463BD {


    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i - 1 < 0 || grid[i - 1][j] == 0) {
                    cnt++;
                }
                if (i + 1 >= m || grid[i + 1][j] == 0) {
                    cnt++;
                }
                if (j - 1 < 0 || grid[i][j - 1] == 0) {
                    cnt++;
                }
                if (j + 1 >= n || grid[i][j + 1] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private int m,n;
    public int islandPerimeter1(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        int cnt = 0;
        cnt += dfs(grid, i - 1, j);
        cnt += dfs(grid, i + 1, j);
        cnt += dfs(grid, i, j - 1);
        cnt += dfs(grid, i, j + 1);

        return cnt;
    }

    public static void main(String[] args) {

    }
}
