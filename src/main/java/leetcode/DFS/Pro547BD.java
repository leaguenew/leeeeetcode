package leetcode.DFS;

/**
 * @program: risk-leecode-example
 * @description: 思路错误，代码不对
 * @author: niuliguo
 * @create: 2020-02-18 21:52
 **/
public class Pro547BD {

    private int m, n;
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        m = M.length;
        n = M[0].length;
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i ==j) {
                    M[i][j] = 0;
                }
                if (M[i][j] == 1) {
                    dfs(M, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n ||
                i == j || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        grid[j][i] = 0;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {

    }
}
