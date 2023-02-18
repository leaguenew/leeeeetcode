package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class Pro36 {

    private Map<Character, Boolean> map = new HashMap<>();
    public boolean isValidSudoku(char[][] board) {
        boolean flag = true;
        flag = column(board);
        if (!flag) {
            return flag;
        }
        flag = row(board);
        if (!flag) {
            return flag;
        }
        flag = matrix(board);
        if (!flag) {
            return flag;
        }

        return flag;
    }

    private boolean column(char[][] board) {
        map.clear();
        for(int col = 0; col < 9; col++) {
            for(int row = 0; row < 9; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (map.get(board[row][col]) != null && map.get(board[row][col])) {
                    return false;
                } else {
                    map.put(board[row][col], true);
                }
            }
            map.clear();
        }

        return true;
    }
    private boolean row(char[][] board) {
        map.clear();
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (map.get(board[row][col]) != null && map.get(board[row][col])) {
                    return false;
                } else {
                    map.put(board[row][col], true);
                }
            }
            map.clear();
        }

        return true;
    }
    private boolean matrix(char[][] board) {
        int[][] startPos = new int[][]{
                {0,0},
                {0,3},
                {0,6},
                {3,0},
                {3,3},
                {3,6},
                {6,0},
                {6,3},
                {6,6}
        };
        map.clear();
        for(int i = 0; i < 9; i++) {
            int row = startPos[i][0];
            int col = startPos[i][1];
            for (int r = row; r < row + 3; r++) {
                for(int c = col; c < col + 3; c++) {
                    if (board[r][c] == '.') {
                        continue;
                    }
                    if (map.get(board[r][c]) != null && map.get(board[r][c])) {
                        return false;
                    } else {
                        map.put(board[r][c], true);
                    }
                }
            }
            map.clear();
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] boards = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        Pro36 pro36 = new Pro36();
        boolean res = pro36.isValidSudoku(boards);
        System.out.println(res);
    }
}
