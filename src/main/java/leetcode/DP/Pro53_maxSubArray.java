package leetcode.DP;


/**
 * 1.划分状态，即划分子问题。
 * 2.状态表示，dp[i]或者dp[i][j]代表什么。
 * 3.状态转移，dp[i] = max{dp[i - 1], dp[i - 1] + num[i]);
 * 4.确定边界：初始值，dp[0]，dp[1]是什么
 * 5.取得结果
 */
public class Pro53_maxSubArray {

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Pro53_maxSubArray pro = new Pro53_maxSubArray();

        int nums[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int res = pro.maxSubArray(nums);

        System.out.println(res);
    }
}
