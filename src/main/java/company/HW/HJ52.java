package company.HW;

import java.util.Scanner;

public class HJ52 {

    /**
     * 0.子问题，两个字符串的编辑距离和其子串的编辑距离有关系
     * 1.状态定义：dp[i][j] = str1[0..i] 和 str2[0..j]的编辑距离
     * 2.状态转移方程：
     * if str1[i] == str2[j]:
     *     dp[i][j] = min(dp[i - 1][j - 1],  dp[i-1][j] + 1, dp[i][j-1] + 1)
     * else:
     *     dp[i][j] = 1 + min(dp[i - 1][j - 1],  dp[i-1][j], dp[i][j-1])
     * 3.初始化
     *     dp[0][0] = str1[0] == str2[0] ? 0 : 1
     *     dp[0][j] = dp[0][0] + j - 1
     *     dp[i][0] = dp[0][0] + i - 1
     * 4.结果：dp[m-1][n-1]
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        //init
        for(int j = 1; j < n + 1; j++) {
            dp[0][j] =  + j;
        }
        for(int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],  Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                } else {
                    dp[i][j] =  Math.min(dp[i - 1][j - 1] + 1,  Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}
