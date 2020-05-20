package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description: https://github.com/azl397985856/leetcode/blob/master/problems/516.longest-palindromic-subsequence.md
 * dp[i][j]: 从i到j的最大字符串长度，结果为dp[0][len - 1]
 * 状态转移方程：
 * if (s[i] === s[j]) {
        dp[i][j] = dp[i + 1][j - 1] + 2;
    } else {
        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
    }
 * 方向：自下向上，从左到右

 * 另解：其实就是求ｓ和ｓ的逆序的最长公共子序列的。转化成最长公共子序列问题就迎刃而解了。
 * @author: niuliguo
 * @create: 2020-02-02 10:54
 **/
public class Pro516 {

    public int longestPalindromeSubseq(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[][] dp = new int[len][len];
        for(int row = len - 1; row >= 0; row--) {
            for(int col = row; col < len; col++) {
                if (row == col) {
                    dp[row][col] = 1;
                } else if (s.charAt(row) == s.charAt(col)) {
                    dp[row][col] = dp[row + 1][col - 1] + 2;
                } else {
                    dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        Pro516 pro = new Pro516();

//        String s = "bbbab";
        String s = "cbbd";

        System.out.println(pro.longestPalindromeSubseq(s));

    }
}
