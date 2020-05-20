package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * 算法参考：Pro5
 * @author: niuliguo
 * @create: 2020-02-02 10:19
 **/
public class Pro647 {

    public int countSubstrings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[][] dp = new int[len][len];
        int dis = Integer.MIN_VALUE;
        int count = 0;
        for(int col = 0; col < len; col++) {
            for(int row = 0; row <= col; row++) {
                if (row == col) {
                    dp[row][col] = 1;
                } else if (row + 1 == col) {
                    dp[row][col] =  s.charAt(row) == s.charAt(col) ? 1 : 0;
                } else {
                    dp[row][col] =  s.charAt(row) == s.charAt(col) && dp[row + 1][col - 1] == 1 ? 1 : 0;
                }

                if (dp[row][col] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Pro647 pro = new Pro647();

        String s = "aaa";

        System.out.println(pro.countSubstrings(s));

    }
}
