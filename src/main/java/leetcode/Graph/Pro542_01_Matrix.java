package leetcode.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-07-04 16:43
 **/
public class Pro542_01_Matrix {


    /**
     * BFS
     * 1.定义一个结果矩阵resMatrix，定义中间访问矩阵statusMatrix，定义队列Queue
     * 2.just do bfs
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        int[][] resMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    resMatrix[i][j] = 0;
                    continue;
                }

                Queue<Integer> queue = new LinkedList<>();
                queue.add(matrix[i][j]);
                while(!queue.isEmpty()) {

                }
            }
        }

        return resMatrix;
    }

    /**
     * 1.DFS
     * @param matrix
     * @return
     */
    public int[][] updateMatrix1(int[][] matrix) {
        return new int[0][0];
    }

    /**
     * 1.DP
     * @param matrix
     * @return
     */
    public int[][] updateMatrix2(int[][] matrix) {
        return new int[0][0];
    }

    public static void main(String[] args) {
        Pro542_01_Matrix pro = new Pro542_01_Matrix();
        int[][] matrix = new int[][]{
                {1,2,3},
                {1,2,3}
        };

        System.out.println(pro.updateMatrix(matrix));
    }
}
