package leetcode.DFS;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-02 21:15
 **/
public class Pro79 {

    private int row, col;
    private  boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0 || null == word || word.length() == 0) {
            return false;
        }

        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        char[] chars = word.toCharArray();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (board[i][j] == chars[0] && dfs(board, chars, i, j, 0)  ) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int i , int j, int len) {
        if (len == chars.length) {
            return true;
        }

        if (i < 0 || i >= row || j < 0 || j >= col ||
                visited[i][j] || board[i][j] != chars[len]) {
            return false;
        }

        visited[i][j] = true;

        if (dfs(board, chars, i + 1, j, len + 1)
            || dfs(board, chars, i - 1, j, len + 1)
            || dfs(board, chars, i, j - 1, len + 1)
            || dfs(board, chars, i, j + 1, len + 1)) {
            return true;
        }

        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {

    }
}
