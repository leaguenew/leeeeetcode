package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-05 23:29
 **/
public class Pro59 {

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int num = 0;
        while (true) {
            //left -> right
            for(int i = left; i <= right; i++) {
                matrix[up][i] = ++num;
            }
            up++;
            if (up > down) {
                break;
            }
            //up -> down
            for(int i = up; i <= down; i++) {
                matrix[i][right] = ++num;
            }
            right--;
            if (right < left) {
                break;
            }
            //right -> left
            for(int i = right; i >= left; i--) {
                matrix[down][i] = ++num;
            }
            down--;
            if (down < up) {
                break;
            }
            //down -> up
            for(int i = down; i >= up; i--) {
                matrix[i][left] = ++num;
            }
            left++;
            if (right < left) {
                break;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

    }
}
