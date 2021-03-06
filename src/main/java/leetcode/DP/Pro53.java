package leetcode.DP;

public class Pro53 {

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
        Pro53 pro = new Pro53();

        int nums[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int res = pro.maxSubArray(nums);

        System.out.println(res);
    }
}
