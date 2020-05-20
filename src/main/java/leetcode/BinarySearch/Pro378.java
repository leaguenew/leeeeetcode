package leetcode.BinarySearch;

import java.util.*;

public class Pro378 {

    public int kthSmallest(int[][] matrix, int k) {

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                list.add(matrix[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(k - 1);
    }

    public static void main(String[] args) {
        Pro378 pro = new Pro378();

        int[][] matrix = new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int res = pro.kthSmallest(matrix, 8);

        System.out.println(res);
    }
}
