package company.HW;


import java.util.Scanner;

/**
 * 子问题：最长公共子串
 * 状态定义dp[i][j]: 第一个字符串以i结尾，第二个字符串以j结尾最长公共子串的长度
 * 转移方程:
 *
 *
 * 初始状态：
 * 结果：记录最大值
 */
public class HJ65 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m][n];
        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
        int maxLen = 0, posi = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
                    } else {
                        dp[0][j] = str1.charAt(0) == str2.charAt(j) ? 1 : dp[0][j - 1];
                    }
                } else if (j == 0){
                    if (i == 0) {
                        dp[0][0] = str1.charAt(i) == str2.charAt(0) ? 1 : 0;
                    } else {
                        dp[i][0] = str1.charAt(i) == str2.charAt(0) ? 1 : dp[i - 1][0];
                    }
                } else {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            posi = i;
                        }
                    } else {
                        dp[i][j] = 0;
                    }

                }
            }
        }

        System.out.println(str1.substring(posi - maxLen, maxLen));
    }
}
