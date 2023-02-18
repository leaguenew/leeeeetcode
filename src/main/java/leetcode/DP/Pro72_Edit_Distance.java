package leetcode.DP;

/**
 * @program: leeeeetcode
 * @description:
 * @author: niuliguo
 * @create: 2020-07-18 22:35
 **/
public class Pro72_Edit_Distance {

    /**
     * 动态规划：
     * 1.子问题，两个字符串的编辑距离和其子串的编辑距离有关系
     * 2.状态定义：dp[i][j], word1[0..i]和word2[0..j]的编辑距离
     * 3.状态转移方程：
     * if word1[i] == word2[j]:
     *    dp[i][j] = min(dp[i][j-1] + 1, dp[i-1][j] + 1, dp[i-1][j-1])
     * else:
     *    插入word1: 1 + dp[i][j - 1]
     *    删除word1: 1 + dp[i-1][j]
     *    更新word:  1 + dp[i-1][j  - 1]
     *    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
     * 4.初始化：
     *    dp[0][0] = word1[0] == word2[0] ? 0 : 1
     *    dp[0][j] = dp[0][0] + j  - 1;
     *    dp[i][0] = dp[0][0] + i  - 1;
     * 5.结果：
     *    dp[word1.length - 1][word2.length - 1]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i < word1.length() + 1;  i++) {
            for(int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))  {
                    dp[i][j] = Math.min(dp[i][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i-1][j-1]));
                }  else  {
                    dp[i][j] = Math.min(dp[i][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i-1][j-1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }


    /**
     * 递归：
     * if word1[i] == word2[j]:
     *   比较word1[0..i-1]和word2[0..j-1]
     * else:
     *   三个选择：
     *   插入word1，比较word1[0..i]和word2[0..j-1]结果
     *   删除word1，比较word1[0..i-1]和word2[0..j]结果
     *   更新word1，比较word1[0..i-1]和word2[0..j - 1]结果
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance1(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }

        if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)) {
            return minDistance1(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        }

        return 1 + Math.min(
            Math.min( minDistance1(word1, word2.substring(0, word2.length() - 1)),
                    minDistance1(word1.substring(0, word1.length() - 1), word2)
                    ),
            minDistance1(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1))
        );
    }
}
