package leetcode.DP;

public class Pro213 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];

        process(dp1, nums,0, nums.length - 2); //0 ~ length - 2
        process(dp2, nums,1, nums.length - 1); //1 ~ length - 1

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }

    private void process(int[] dp, int[] nums, int l, int r) {
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        for(int i = l + 2; i <= r; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
    }

    public static void main(String[] args) {

        Pro213 pro = new Pro213();

//        int nums[] = new int[]{2,7,9,3,1};
        int nums[] = new int[]{1,2,3,1};
        System.out.println(pro.rob(nums));
    }
}
