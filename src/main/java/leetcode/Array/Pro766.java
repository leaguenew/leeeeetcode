package leetcode.Array;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-02-06 23:30
 **/
public class Pro766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for(int col = 0; col < colLen; col++) {
            int row = 0;
            int baseVal = matrix[row][col];
            int colTmp = col;
            while(row < rowLen && colTmp < colLen && matrix[row][colTmp] == baseVal) {
                row++;
                colTmp++;
            }
            if (row == rowLen || colTmp == colLen) {
                continue;
            } else {
                return false;
            }
        }

        for(int row = 1; row < rowLen; row++) {
            int col = 0;
            int baseVal = matrix[row][col];
            int rowTmp = row;
            while(rowTmp < rowLen && col < colLen && matrix[rowTmp][col] == baseVal ) {
                rowTmp++;
                col++;
            }
            if (rowTmp == rowLen || col == colLen) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Pro766 pro = new Pro766();
        int[][] matrix = new int[][] {
                {11,74,0,93},
                {40,11,74,1},
                {2, 40,11,74}
        };
        System.out.println(pro.isToeplitzMatrix(matrix));
    }
}
