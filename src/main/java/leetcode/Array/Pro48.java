package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * /*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
 * @author: niuliguo
 * @create: 2020-02-06 23:12
 **/
public class Pro48 {

    /**
     * clockwise rotate
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //reverse up to down
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n / 2; row++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n - row - 1][col];
                matrix[n - row - 1][col] = tmp;
            }
        }

        //swap the symmetry
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < col; row++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
