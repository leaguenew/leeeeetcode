package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-04-10 00:02
 **/
public class Pro392 {

    public boolean isSubsequence(String s, String t) {
        int len = longestCommonSubsequence(s, t);

        return len == s.length();
    }

    /**
     *
     * @param text1
     * @param text2
     * @return Memory Limit Exceeded
     */
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
}
