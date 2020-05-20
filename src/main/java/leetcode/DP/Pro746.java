package leetcode.DP;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2019-09-14 21:28
 **/
public class Pro746 {


    public int minCostClimbingStairs(int[] cost) {

        int dp[] = new int[cost.length];
        if (cost.length >= 1) {
            dp[0] = cost[0];
        }
        if (cost.length >= 2) {
            dp[1] = cost[1];
        }

        for(int i = 2 ; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[dp.length - 2], dp[dp.length - 1]);
    }

    public static void main(String[] args) {
        Pro746 pro = new Pro746();

        int []cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int []cost = new int[]{10, 15, 20};

        System.out.println(pro.minCostClimbingStairs(cost));
    }
}
