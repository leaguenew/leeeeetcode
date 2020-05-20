package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-04-09 23:44
 **/
public class Pro792 {

    public int numMatchingSubseq(String S, String[] words) {
        if (null == S || S.length() == 0 || null == words || words.length == 0) {
            return 0;
        }

        int cnt = 0;
        for(int i = 0; i < words.length; i++) {
            if (longestCommonSubsequence(S, words[i])) {
                cnt++;
            }
        }

        return cnt;
    }

    /**
     * 转换成最长公共子序列问题，如果最长公共子序列长度为word.length，那么返回true，否则false
     * 参考Pro1143
     * @return : Time Limit Exceeded
     */
    public boolean longestCommonSubsequence(String text1, String text2) {

        if (text1.length() < text2.length()) {
            return false;
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

        return dp[len1][len2] == text2.length();
    }
}
