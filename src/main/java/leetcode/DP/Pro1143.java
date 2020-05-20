package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description: 动态规划
 * 子问题：两个字符串的最长公共子序列跟他们的子串的最长公共子序列有关系
 * 状态定义：dp[i][j] = s1[1-i] 与 s2[1-j]的最长公共子序列
 * 状态转移方程：
 * if(s1[i] == s2[j]) dp[i - 1][j - 1] + 1
 * else max(dp[i - 1][j], dp[i][j - 1])
 * 初始化状态：dp[0][*] = 0 , dp[*][0] = 0
 * @author: niuliguo
 * @create: 2020-03-18 14:31
 **/
public class Pro1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (null == text1 || null == text2 || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1 + 1; i++) {
            for(int j = 0; j < len2 + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (text1.substring(i - 1, i).equals(text2.substring(j - 1, j))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {

    }
}
