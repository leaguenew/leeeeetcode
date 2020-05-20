package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-04-09 23:02
 **/
public class Pro566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (null == nums || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        int m = nums[0].length;
        if (r * c > n * m) {
            return nums;
        }

        int[][] matrix = new int[r][c];
        int cnt = 0;
        int rTmp = 0, cTmp = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if (cnt++ == r * c) {
                    break;
                }
                matrix[rTmp][cTmp % c] = nums[row][col];
                cTmp += 1;
                rTmp = cTmp / c;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Pro566 pro = new Pro566();
        int[][] nums = new int[][]{
                {1, 2},
                {3, 4}
        };
        System.out.println(pro.matrixReshape(nums, 4, 1));
    }
}
