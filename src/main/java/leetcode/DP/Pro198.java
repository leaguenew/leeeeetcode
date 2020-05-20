package leetcode.DP;

public class Pro198 {
    public int rob(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int dp[] = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Pro198 pro = new Pro198();

        int nums[] = new int[]{2,7,9,3,1};
        System.out.println(pro.rob(nums));
    }
}
