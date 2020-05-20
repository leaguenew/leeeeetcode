package leetcode.DFS;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: risk-leecode-example
 * @description:
 * 农村包围城市，把与四条边上的'O'找到并通过dfs找到与之连同的'O'并替换成'Y'，那么剩下的'O'就是需要替换成'X',而把'Y'换成'O'
 * @author: niuliguo
 * @create: 2020-02-17 21:02
 **/
public class Pro130 {

    private Map<Integer, Integer> touchedMap = new HashMap<>();//key: i; val: j
    private int m, n;
    public void solve(char[][] board) {
        if (null == board || board.length == 0) {
            return;
        }

        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if ( i != 0 && i != m - 1 &&
                        j > 0 && j < n - 1) {
                    continue;
                }
                if (board[i][j] == 'O') {
                    dfs(board, i ,j);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n ||
                board[i][j] != 'O') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'Y';
            dfs(board, i - 1, j );
            dfs(board, i + 1, j );
            dfs(board, i, j - 1);
            dfs(board, i, j + 1 );
        }
    }

    public static void main(String[] args) {

    }
}
