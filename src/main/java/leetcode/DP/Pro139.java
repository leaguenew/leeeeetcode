package leetcode.DP;

import java.util.List;

/**
 * @program: risk-leecode-example
 * @description:
 * 问题定义：字符串s能不能由wordDict单词组成，拆分为s[0,i], s[i + 1, len - 1]在不在wordDict中
 * dp[i] : 定义为s[0, i]是否能能由wordDict中单词组成
 * 状态转移方程：dp[i] = dp[0, j] && s.substring(j + 1, i + 1) in wordDict; 0 <= j <= i
 * 结果：dp[len - 1]
 * @author: niuliguo
 * @create: 2020-03-06 14:59
 **/
public class Pro139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (null == s || s.length() == 0) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j,  i));
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

    }
}
