package leetcode.DP;

import java.util.ArrayList;
import java.util.List;


public class Pro120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                    continue;
                }
                if (j == i) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        int min = dp[n - 1][0];
        for(int i = 1; i < n; i++) {
            if (dp[n - 1][i] < min) {
                min = dp[n - 1][i];
            }
        }

//        for(int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return min;
    }

    public static void main(String[] args) {
        Pro120 pro = new Pro120();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(2); list.add(l1);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(3);l2.add(4);list.add(l2);
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(6);l3.add(5);l3.add(7);list.add(l3);
        List<Integer> l4 = new ArrayList<Integer>();
        l4.add(4);l4.add(1);l4.add(8);l4.add(3); list.add(l4);

        System.out.println(list);

        System.out.println(pro.minimumTotal(list));
    }
}
