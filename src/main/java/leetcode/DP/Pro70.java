package leetcode.DP;

public class Pro70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n-1];
    }

    public static void main(String[] args) {

        Pro70 pro = new Pro70();
        System.out.println(pro.climbStairs(10));

        System.out.println(pro.climbStairs1(10));
    }
}
