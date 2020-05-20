package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * 算法：二维dp[i][j] : 字符串从i到j是否是回文串, i = row , j = col
 * i == j : dp[i][j] = 1
 * i + 1 = j : dp[i][j] = s[i] == s[j] ? 1 : 0;
 * i + 1 < j : dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1] ? 1 : 0;
 * 通过画图可以知道，需要按列来对二维数据dp进行赋值。
 * 最后遍历dp，找到j - i最大的值即可。
 * 方向：自上而下，从左到右
 * @author: niuliguo
 * @create: 2020-02-01 23:53
 **/
public class Pro5 {

    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }

        int len = s.length();
        int[][] dp = new int[len][len];
        int dis = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for(int col = 0; col < len; col++) {
            for(int row = 0; row <= col; row++) {
                if (row == col) {
                    dp[row][col] = 1;
                } else if (row + 1 == col) {
                    dp[row][col] =  s.charAt(row) == s.charAt(col) ? 1 : 0;
                } else {
                    dp[row][col] =  s.charAt(row) == s.charAt(col) && dp[row + 1][col - 1] == 1 ? 1 : 0;
                }

                if (dp[row][col] == 1 && col - row + 1 > dis) {
                    dis = col - row + 1;
                    start = row;
                    end = col;
                }
            }
        }

//        for(int row = 0; row < len; row++) {
//            for(int col = 0; col < len; col++) {
//                System.out.print(dp[row][col] + " ");
//            }
//            System.out.println();
//        }

//        int dis = Integer.MIN_VALUE;
//        int start = 0, end = 0;
//        for(int col = 0; col < len; col++) {
//            for(int row = 0; row <= col; row++) {
//                if (dp[row][col] == 1 && col - row + 1 > dis) {
//                    dis = col - row + 1;
//                    start = row;
//                    end = col;
//                }
//            }
//        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Pro5 pro = new Pro5();

        String s = "babad";

        System.out.println(pro.longestPalindrome(s));

        System.out.println(s.charAt(0) == s.charAt(2));
    }
}
